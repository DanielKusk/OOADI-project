package com.company;

import java.net.*;
import java.io.*;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class GreenhouseClient {
    private Socket clientSocket = null;
    private DataInputStream userInput = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // constructor socket and input output streams
    public GreenhouseClient(String address, int port) {
        // establish a connection
        try {
            clientSocket = new Socket(address, port);
            System.out.println("Connected");
            // takes input from terminal
            userInput = new DataInputStream(System.in);
            // sends output to the socket
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        // string to read message from input
        String line = "";
        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = userInput.readLine();
                out.writeUTF(line);
                System.out.println(in.readLine());
            }
            catch (IOException e) {
                System.out.println("e");
            }
        }

    // close the connection
            try {
            in.close();
            out.close();
            clientSocket.close();
        }
            catch(IOException e) {
                System.out.println(e);
            }

        }
    public static void main(String[] args) throws IOException {
        GreenhouseClient clientServer = new GreenhouseClient("127.0.0.1", 5000);
    }
}


//import java.net.*;
//        import java.io.*;
//        import java.awt.GraphicsConfiguration;
//        import javax.swing.JFrame;
//
//public class GreenhouseClient {
//
//    public static void main(String[] args) throws IOException {
//
//        try {
//            System.out.println("Client started");
//            Socket clientSocket = new Socket("localhost", 9806);
//            while (true) {
//                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
//                System.out.println("Enter a string");
//                String str = userInput.readLine();
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                out.println(str);
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                System.out.println(in.readLine());
//                if (str.equals("close")){
//                    break;
//                }
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}