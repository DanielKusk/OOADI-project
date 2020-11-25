package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//The server handles the server-client and object communications on the server side.
public class GreenhouseServer {
    //Server attributes.
    private final ServerSocket serverSocket;
    private Socket clientSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    //Server constructor, determines port for server socket.
    public GreenhouseServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started");
    }

    //Server methods.

    //Starts the server
    public void startServer() throws IOException {
        System.out.println("Waiting for clients...");
        //Waits for a client to connect to the socket.
        clientSocket = serverSocket.accept();
        System.out.println("Connection established");
        //Opens streams to take input and give output from the client socket.
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        out = new DataOutputStream(clientSocket.getOutputStream());
    }

    //Stops the server from listening, sending responses and closes the sockets.
    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    //Reads strings sent from the connected client.
    public String readCommand() throws IOException {
        return in.readUTF();
    }

    //Writes a response to the connected client
    public void writeResponse(String msg) throws IOException {
        out.writeUTF(msg);
    }

    //Checks if the client is still connected.
    public boolean isClientConnected() {
        return clientSocket.isConnected();
    }

}