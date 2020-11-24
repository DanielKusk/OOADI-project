package com.company.server;

import java.util.ArrayList;
import java.util.List;

public class Greenhouse {
    //Handles the Greenhouse plants
    private final int totalSpots = 15;
    private int vacantSpots;
    private final List<Plant> plantList;


    public Greenhouse() {
        this.plantList = new ArrayList<>();
        this.setVacantSpots();
    }

    public int getVacantSpots() {
        return vacantSpots;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    private void setVacantSpots() {
        vacantSpots = totalSpots - plantList.size();
    }

    public String addPlant(String type, int stage) {
        if (vacantSpots >= 1) {
            switch (type) {
                case "Lemon" -> plantList.add(new Lemon(stage));
                case "BabyCucumber" -> plantList.add(new BabyCucumber(stage));
                case "BellPepper" -> plantList.add(new BellPepper(stage));
                case "Grape" -> plantList.add(new Grape(stage));
                case "Tomato" -> plantList.add(new Tomato(stage));
            }
            setVacantSpots();
            //log plant added
            return "New " + type + " stage " + stage + " added";
        } else {
            return "No more vacant spots.";
        }
    }

    public void waterPlants() {
        for (Plant plant : this.getPlantList()) {
            plant.setWaterLevel(5 - plant.getWaterLevel());
        }
        //log plants watered
    }

    public String growPlants() {
        StringBuilder plantsGrown = new StringBuilder();
        for (Plant plant : this.getPlantList()) {
            if (plant.getWaterLevel() >= 1) {
                plant.setWaterLevel(-1);
                plant.addGrowth(1);
                plant.setHeight(plant.getStage());
                plantsGrown.append(plant.plantGrown());
                //Log plant has grown
            }
        }
        return plantsGrown.toString();
    }
}