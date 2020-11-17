package com.company.server;

public class CommandResolver {
    public CommandResolver(){

    }

    public String ResolveMessage(String msg){
        switch (msg) {
            case "overview" -> {
                return "Hello. Overview here.";
            }
            case "water" -> {
                return "Plants have been watered.";
            }
            case "addplant" -> {
                return "Hello. I'm your new plant.";
            }
            case "log" -> {
                return "Hello. Log here.";
            }
            default -> {
                return "Unknown command received.";
            }
        }
    }
}
