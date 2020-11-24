package com.company.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public String addPlant(String type) throws IOException{
        if (vacantSpots >= 1) {
            switch (type) {
                case "Lemon" -> plantList.add(new Lemon());
                case "BabyCucumber" -> plantList.add(new BabyCucumber());
                case "BellPepper" -> plantList.add(new BellPepper());
                case "Grape" -> plantList.add(new Grape());
                case "Tomato" -> plantList.add(new Tomato());
            }
            setVacantSpots();
            //log plant added
            writeToLog("New " + type + " stage 0 added");
            return "New " + type + " stage 0 added";
        } else {
            return "No more vacant spots.";
        }
    }

    public void waterPlants() throws IOException{
        for (Plant plant : this.getPlantList()) {
            plant.setWaterLevel(5 - plant.getWaterLevel());
        }
        //log plants watered
        writeToLog("Plants watered.");
    }

    public String growPlants() throws IOException{
        StringBuilder plantsGrown = new StringBuilder();
        for (Plant plant : this.getPlantList()) {
            if (plant.getWaterLevel() >= 1) {
                plant.setWaterLevel(-1);
                plant.addGrowth(1);
                plant.setHeight(plant.getStage());
                plantsGrown.append(plant.plantGrown());
            }
        }
        //Logs plant has grown
        writeToLog(plantsGrown.toString());
        return plantsGrown.toString();
    }

    public void writeToLog(String textLine) throws IOException {
        FileWriter write = new FileWriter("log.txt", true);
        PrintWriter printLine = new PrintWriter(write);

        printLine.printf("%s" + "%n", textLine);

        printLine.close();
    }

    public String getLog() throws IOException {
        String log = "";

        log = new String (Files.readAllBytes(Paths.get("log.txt")));

        return log;
    }
}