package com.company.server;

public class CommandResolver {
    String returnString = "";
    public CommandResolver(){

    }
    
    public String ResolveMessage(String msg, Greenhouse obj){
        switch (msg) {
            case "overview" -> {
                for(Plant plant : obj.getPlantList()) {
                    returnString = returnString + "Type: " + plant.getClass().getSimpleName() +
                            "\r\n" + " Stage: " + plant.getStage() +
                            "\r\n" + " Water level: " + plant.getWaterLevel();
                            //"\r\n" + " Height: " + plant.getHeight();
                }
                return returnString;
            }
            case "water" -> {
                return "Plants have been watered.";
            }
            case "addplant" -> {
                obj.addPlant("Lemon", 2);
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
