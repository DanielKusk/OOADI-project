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
                    StringBuilder returnString = new StringBuilder();
                    for (Plant plant : obj.getPlantList()) {
                        returnString.append("Type: ").append(plant.getClass().getSimpleName()
                        ).append(", Stage: ").append(plant.getStage()
                        ).append(", Water level: ").append(plant.getWaterLevel()
                        ).append(", Height: ").append(plant.getHeight()).append("\r\n");
                    }
                    return returnString.toString();
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
