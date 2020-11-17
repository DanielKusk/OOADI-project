package com.company.server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean stopServer = false;
        GreenhouseServer server = new GreenhouseServer(5000);
        server.startServer();
        var CommandResolver = new CommandResolver();
        while (server.isClientConnected() && !stopServer) {
            try {
                var msg = server.readCommand();
                server.writeResponse(CommandResolver.ResolveMessage(msg));
            } catch (IOException e) {
                stopServer = true;
                System.out.println(e.getMessage());
            }
        }
        server.close();
    }
}
