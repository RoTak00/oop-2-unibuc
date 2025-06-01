package lab13.labwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {
        String url = "localhost";
        int port = 8092;

        try (Socket socket = new Socket(url, port);
             BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in))) {

            Thread serverReader = new Thread(() -> {
                try {
                    String line;
                    while((line = serverIn.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server");
                }
            });
            serverReader.start();

            String message;
            while((message = clientIn.readLine()) != null)
            {
                serverOut.println(message);

                if(message.equals("exit"))
                    break;
            }

        }
        catch (IOException e)
        {

        }
    }
}
