import java.net.*;
import java.io.*;

public class GreenhouseServer {
    public static void main(String[] args) throws IOException {
        try {

            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(9806);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established");
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String str = in.readLine();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Server says:" + str);
                if (str.equals("close")) {
                    serverSocket.close();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
