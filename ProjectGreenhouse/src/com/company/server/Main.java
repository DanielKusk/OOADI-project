package com.company.server;

import java.io.IOException;

public class Main {
    /*The server main starts up the server by creating an instance of GreenhouseServer,
    Greenhouse and CommandResolver, and utilises the methods of GreenhouseServer and
    CommandResolver to handle the all server side object communication.
     */
    public static void main(String[] args) throws IOException {
        //Creates an attribute to tell the while loop when to stop.
        boolean stopServer = false;
        //Creates an instance of the server.
        GreenhouseServer server = new GreenhouseServer(5000);
        //Creates an instance of the greenhouse
        Greenhouse greenhouse = new Greenhouse(new PlantFactory());
        //Starts the server
        server.startServer();
        //Creates an instance of Command resolver
        var CommandResolver = new CommandResolver();
        while (server.isClientConnected() && !stopServer) {
            try {
                //Listens to the socket
                var msg = server.readCommand();
                //Utilises the Command Resolver to create a response to the client
                server.writeResponse(CommandResolver.ResolveMessage(greenhouse, msg));
            } catch (IOException e) {
                //If the server socket or response to client fails: Stop the while loop and print an error.
                stopServer = true;
                System.out.println(e.getMessage());
            }
        }
        //After the while loop the server stops listening and closes the sockets.
        server.close();
    }
}
