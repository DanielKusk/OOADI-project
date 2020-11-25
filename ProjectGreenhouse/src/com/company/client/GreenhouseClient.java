package com.company.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//The client handles all client-server and object communications on the client side.
public class GreenhouseClient implements IGreenhouseClient {
    //Client attributes.
    private Socket clientSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private final String Address;
    private final int Port;

    //Client constructor, sets IP and Port for server connection.
    public GreenhouseClient(String address, int port) {
        Address = address;
        Port = port;
    }

    //Opens communication with the server.
    @Override
    public void open() throws IOException {
        //Establishes connection to the server.
        clientSocket = new Socket(Address, Port);
        System.out.println("Connected");
        //Opens communication streams for client-server communication.
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
    }

    //Closes communications with the server
    @Override
    public void close(){
        try {
            //Closes the streams.
            in.close();
            out.close();
            //Closes the socket.
            clientSocket.close();
        } catch (IOException e) {
            //Prints errors.
            System.out.println(e.getMessage());
        }
    }

    //Sends a message to the server and listens for a response.
    @Override
    public String writeCommand(String msg) throws IOException {
        out.writeUTF(msg);
        return in.readUTF();
    }

    //Requests the server to add a plant of same type as method argument.
    @Override
    public String addPlant(String type) throws IOException {
        writeCommand(type);
        return writeCommand("addPlant");
    }

    //Requests the server to water plants.
    @Override
    public String waterPlants() throws IOException {
        return writeCommand("waterPlants");
    }

    //Requests a plant and greenhouse overview from the server.
    @Override
    public String getOverview() throws IOException {
        return writeCommand("overview");
    }

    //Requests the log from the server.
    @Override
    public String getLog() throws IOException {
        return writeCommand("log");
    }

    //Requests the server to skip forward one day.
    @Override
    public String nextDay() throws IOException {
        return writeCommand("nextDay");
    }
}