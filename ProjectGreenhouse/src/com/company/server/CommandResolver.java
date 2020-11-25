package com.company.server;

import java.io.IOException;

//CommandResolver handles the commands issued by the client GUI
public class CommandResolver {
    //Attribute for plant type.
    private String type = "";

    //CommandResolver constructor.
    public CommandResolver() {

    }

    //Sends method commands to the greenhouse based on the string message from the client.
    public String ResolveMessage(Greenhouse obj, String msg) throws IOException {
        //Checks the message.
        switch (msg) {
            case "addPlant" -> {
                //Requests greenhouse to add a new plant and returns information of new plant.
                return obj.addPlant(type);
            }
            case "waterPlants" -> {
                //Requests greenhouse to water plants.
                obj.waterPlants();
                return "Plants have been watered.";
            }
            case "overview" -> {
                //Requests an overview of the Greenhouse and housed plants.
                return obj.getOverview();
            }
            case "log" -> {
                //Requests the greenhouse log and returns this to the client.
                return obj.getLog();
            }
            case "nextDay" -> {
                //Requests the greenhouse to skip to next day and returns updated plant information to the client.
                obj.nextDay();
                return obj.growPlants();
            }
            default -> {
                //Updates the type argument for the addPlant call.
                setType(msg);
                return "Unknown command";
            }
        }
    }

    //Sets the type attribute.
    public void setType(String type) {
        this.type = type;
    }
}
