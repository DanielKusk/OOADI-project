package com.company.server;

import java.io.IOException;

public class Main {
    /*The server main starts up the server by creating an instance of GreenhouseServer,
    Greenhouse and CommandResolver, and utilises the methods of GreenhouseServer and
    CommandResolver to handle the all server side object communication.
     */
    public static void main(String[] args) throws IOException {
        boolean stopServer = false;
        GreenhouseServer server = new GreenhouseServer(5000);
        Greenhouse greenhouse = new Greenhouse();
        server.startServer();
        var CommandResolver = new CommandResolver();
        while (server.isClientConnected() && !stopServer) {
            try {
                var msg = server.readCommand();
                server.writeResponse(CommandResolver.ResolveMessage(greenhouse, msg));
            } catch (IOException e) {
                stopServer = true;
                System.out.println(e.getMessage());
            }
        }
        server.close();
    }
}
