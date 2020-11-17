package com.company.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GreenhouseClient implements IGreenhouseClient {
    private Socket clientSocket = null;
    private DataInputStream userInput = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private String Address = null;
    private int Port;

    // constructor socket and input output streams
    public GreenhouseClient(String address, int port) {
        Address = address;
        Port = port;
    }

    @Override
    public void open() throws IOException {
        // establish a connection
        clientSocket = new Socket(Address, Port);
        System.out.println("Connected");
        // sends output to the socket
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
    }

    @Override
    public void close(){
        // close the connection
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String writeCommand(String msg) throws IOException {
        out.writeUTF(msg);
        return in.readUTF();
    }

    @Override
    public String getOverview() throws IOException {
        return writeCommand("overview");
    }

    @Override
    public String waterPlants() throws IOException {
        return writeCommand("water");
    }

    @Override
    public String addPlant() throws IOException {
        return writeCommand("addplant");
    }

    @Override
    public String getLog() throws IOException {
        return writeCommand("log");
    }
}