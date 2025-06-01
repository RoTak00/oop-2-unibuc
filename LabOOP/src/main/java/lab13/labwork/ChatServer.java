package lab13.labwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private static int PORT = 8092;
    private static Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet();

    private static final int historyCapacity = 20;
    private static Deque<String> messageHistory = new ArrayDeque<>(historyCapacity);

    public static void main(String[] args) {
        System.out.println("Starting server...");
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true)
            {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket, clientHandlers, messageHistory, historyCapacity);
                clientHandlers.add(handler);
                new Thread(handler).start();
            }
        }
        catch(IOException e)
        {
            //
        }
    }
}


