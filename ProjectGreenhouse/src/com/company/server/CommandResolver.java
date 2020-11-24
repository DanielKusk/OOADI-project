package com.company.server;

import java.io.IOException;

public class CommandResolver {
    //CommandResolver handles the commands issued by the client GUI
    private String type = "";

    public CommandResolver() {

    }

    public String ResolveMessage(Greenhouse obj, String msg) throws IOException {
        switch (msg) {
            case "addPlant" -> {
                return obj.addPlant(type);
            }
            case "waterPlants" -> {
                obj.waterPlants();
                return "Plants have been watered.";
            }
            case "overview" -> {
                StringBuilder returnString = new StringBuilder();
                returnString.append("Vacant spots: ").append(obj.getVacantSpots()).append(" of "
                ).append(obj.getTotalSpots()).append(".\r\n");
                for (Plant plant : obj.getPlantList()) {
                    returnString.append("Type: ").append(plant.getClass().getSimpleName()
                    ).append(", Stage: ").append(plant.getStage()
                    ).append(", Water level: ").append(plant.getWaterLevel()
                    ).append(", Height: ").append(plant.getHeight()).append("\r\n");
                }
                return returnString.toString();
            }
            case "log" -> {
                return obj.getLog();
            }
            case "nextDay" -> {
                obj.nextDay();
                return obj.growPlants();
            }
            default -> {
                setType(msg);
                return "Unknown command";
            }
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
