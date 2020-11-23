package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GreenhouseServer {
    //The server handles the server socket and server-client communication.
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // setting up constructor with port
    public GreenhouseServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started");
        // starting the server and waits for a connection
    }

    public void startServer() throws IOException {
        System.out.println("Waiting for clients...");
        clientSocket = serverSocket.accept();
        System.out.println("Connection established");
        // takes input from the client socket
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        out = new DataOutputStream(clientSocket.getOutputStream());
    }

    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public String readCommand() throws IOException {
        return in.readUTF();
    }

    public void writeResponse(String msg) throws IOException {
        out.writeUTF(msg);
    }

    public boolean isClientConnected() {
        return clientSocket.isConnected();
    }

}