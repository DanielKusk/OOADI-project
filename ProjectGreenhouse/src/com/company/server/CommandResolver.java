package com.company.server;

public class CommandResolver {
    //CommandResolver handles the commands issued by the client GUI
    private String type = "";
    private int stage;

    public CommandResolver() {

    }

    public String ResolveMessage(Greenhouse obj, String msg) {
        if (msg.length() == 1) {
            setStage(msg);
            return "Stage: " + msg + " selected";
        } else {
            switch (msg) {
                case "addPlant" -> {
                    return obj.addPlant(type, stage);
                }
                case "waterPlants" -> {
                    obj.waterPlants();
                    return "Plants have been watered.";
                }
                case "overview" -> {
                    String returnString = "";
                    for (Plant plant : obj.getPlantList()) {
                        returnString = (
                                returnString + "Type: " + plant.getClass().getSimpleName() +
                                        ", Stage: " + plant.getStage() +
                                        ", Water level: " + plant.getWaterLevel() +
                                        ", Height: " + plant.getHeight() + "\r\n"
                        );
                    }
                    return returnString;
                }
                case "log" -> {
                    return "Hello. Log here.";
                }
                case "nextDay" -> {
                    return obj.growPlants();
                }
                default -> {
                    setType(msg);
                    return "Unknown command";
                }
            }
        }

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStage(String stage) {
        this.stage = Integer.parseInt(stage.trim());
    }
}
