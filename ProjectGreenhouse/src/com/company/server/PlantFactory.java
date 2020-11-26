package com.company.server;

public class PlantFactory {
    public Plant getPlant(String type) {
        return switch (type) {
            case "Lemon" -> new Lemon();
            case "BabyCucumber" -> new BabyCucumber();
            case "BellPepper" -> new BellPepper();
            case "Grape" -> new Grape();
            case "Tomato" -> new Tomato();
            default -> null;
        };
    }
}
