package com.company;

import java.net.*;
import java.io.*;

public class GreenhouseServer {
    private ServerSocket serverSocket = null;
    private Socket       clientSocket = null;
    private DataInputStream         in = null;
    private PrintWriter           out = null;

    // setting up constructor with port
    public GreenhouseServer(int port){
        // starting the server and waits for a connection
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for clients...");

            clientSocket = serverSocket.accept();
            System.out.println("Connection established");

            // takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            String line = "";

            // reads message from client until "Over" is sent
            while(!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Server says: " + line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Closing connection");

            // closing the connection
            clientSocket.close();
            in.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        GreenhouseServer server = new GreenhouseServer(5000);

    }

}

//import java.net.*;
//import java.io.*;

//public class GreenhouseServer {
//    public static void main(String[] args) throws IOException {
//        try {
//
//            System.out.println("Waiting for clients...");
//            ServerSocket serverSocket = new ServerSocket(9806);
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Connection established");
//            while (true) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                String str = in.readLine();
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                out.println("Server says:" + str);
//                if (str.equals("close")) {
//                    serverSocket.close();
//                }
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//}