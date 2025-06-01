package lab13.labwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientHandler implements Runnable {

    private final Socket socket;
    private final Set<ClientHandler> clients;

    private BufferedReader in;
    private PrintWriter out;

    private String clientName;

    private int historyCapacity;
    private Deque<String> messageHistory;

    ClientHandler(Socket socket, Set<ClientHandler> clients, Deque<String> messageHistory, int historyCapacity) {
        this.socket = socket;
        this.clients = clients;
        this.messageHistory = messageHistory;
        this.historyCapacity = historyCapacity;

    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name: ");
            clientName = in.readLine();

            showHistory();

            System.out.println(clientName + " has joined the chat");
            broadcastMessage(clientName + " has joined the chat", clientName);


            String message;

            while((message = in.readLine()) != null) {
                if(message.equalsIgnoreCase("exit"))
                {
                    break;
                }

                Pattern privateMessagePattern = Pattern.compile("^/msg\\s+(?:\"([^\"]+)\"|(\\S+))\\s+(.+)$");
                Matcher privateMessageMatcher = privateMessagePattern.matcher(message);

                if(privateMessageMatcher.matches()) {
                    String usernameWithQuotes = privateMessageMatcher.group(1);
                    String usernameWithoutQuotes = privateMessageMatcher.group(2);
                    String messageBody = privateMessageMatcher.group(3);

                    String username = usernameWithQuotes != null ? usernameWithQuotes : usernameWithoutQuotes;

                    trySendMessage(clientName + " (Private): " + messageBody, clientName, username);
                    continue;

                }
                System.out.println(clientName + ": " + message);
                broadcastMessage(clientName + ": " + message, clientName);


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally
        {
            try{
                socket.close();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }

        System.out.println(clientName + " has left the chat");
        broadcastMessage(clientName + " has left the chat", clientName);
        removeClient(this);
    }

    private void broadcastMessage(String message, String from) {
        clients.stream().filter(c -> !c.clientName.equalsIgnoreCase(from)).forEach(client -> client.sendMessage(message));

        if(messageHistory.size() == historyCapacity)
        {
            messageHistory.removeFirst();
        }
        messageHistory.addLast(message);
    }

    private void showHistory()
    {
        if(messageHistory.isEmpty())
            return;

        sendMessage("-- Message history --");
        messageHistory.forEach(this::sendMessage);
    }

    private void trySendMessage(String message, String from, String to) {
        Optional<ClientHandler> destinationClient = clients.stream().filter(c -> c.clientName.equalsIgnoreCase(to)).findFirst();

        if(destinationClient.isPresent() && !from.equalsIgnoreCase(to)) {
            destinationClient.get().sendMessage(message);
        }
        else
        {
            out.println("[ERR] Could not find destination client " + to);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
