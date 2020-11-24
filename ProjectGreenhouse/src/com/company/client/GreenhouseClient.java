package com.company.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GreenhouseClient implements IGreenhouseClient {
    private Socket clientSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private final String Address;
    private final int Port;

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
    public String addPlant(String type) throws IOException {
        writeCommand(type);
        return writeCommand("addPlant");
    }


    @Override
    public String waterPlants() throws IOException {
        return writeCommand("waterPlants");
    }

    
    @Override
    public String getOverview() throws IOException {
        return writeCommand("overview");
    }


    @Override
    public String getLog() throws IOException {
        return writeCommand("log");
    }


    @Override
    public String nextDay() throws IOException {
        return writeCommand("nextDay");
    }
}