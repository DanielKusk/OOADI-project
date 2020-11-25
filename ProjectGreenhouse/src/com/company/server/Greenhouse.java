package com.company.server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//The greenhouse contains and manages the plants.
public class Greenhouse {
    //Greenhouse attributes.
    private int day;
    private final int totalSpots = 15;
    private int vacantSpots;
    private final List<Plant> plantList;

    //Greenhouse constructor.
    public Greenhouse() throws IOException {
        this.day = 1;
        this.plantList = new ArrayList<>();
        this.setVacantSpots();
        writeToLog("Day: " + this.day);
    }

    //Greenhouse methods

    //Greenhouse getter methods, returns attributes.
    public int getVacantSpots() {
        return this.vacantSpots;
    }

    public int getTotalSpots() {
        return this.totalSpots;
    }

    public List<Plant> getPlantList() {
        return this.plantList;
    }

    //Reads the log and returns it in string format.
    public String getLog() throws IOException {
        String log;
        log = new String(Files.readAllBytes(Paths.get("log.txt")));
        return log;
    }

    public String getOverview() {
        //Creates an instance of String builder.
        StringBuilder overview = new StringBuilder();
        //Builds a string containing the Greenhouse overview.
        overview.append("Vacant spots: ").append(this.getVacantSpots()).append(" of "
        ).append(this.getTotalSpots()).append(".\r\n");
        //Iterates through all plant instances to get information for the greenhouse overview.
        for (Plant plant : this.getPlantList()) {
            overview.append(plant.getOverview());
        }
        return overview.toString();
    }

    //Greenhouse setter methods
    private void setVacantSpots() {
        this.vacantSpots = totalSpots - plantList.size();
    }

    //Goes to the next day.
    public void nextDay() throws IOException {
        this.day++;
        //Logs day.
        writeToLog("Day: " + this.day);
    }

    //Adds a new plant to the greenhouse
    public String addPlant(String type) throws IOException {
        //Checks if there are ane vacant spots
        if (this.getVacantSpots() >= 1) {
            //Checks what type of plant is requested and adds the plant to the greenhouse.
            switch (type) {
                case "Lemon" -> plantList.add(new Lemon());
                case "BabyCucumber" -> plantList.add(new BabyCucumber());
                case "BellPepper" -> plantList.add(new BellPepper());
                case "Grape" -> plantList.add(new Grape());
                case "Tomato" -> plantList.add(new Tomato());
            }
            //Updates the amount of vacant spots in the greenhouse.
            setVacantSpots();
            //logs and returns plant added.
            writeToLog("New " + type + " stage 0 added. Vacant spots: " + this.getVacantSpots() +
                    " of " + this.getTotalSpots() + ".");
            return "New " + type + " stage 0 added. Vacant spots: " + this.getVacantSpots() +
                    " of " + this.getTotalSpots() + ".";
        } else {
            //Tells the user that the greenhouse has no more vacant spots.
            return "No more vacant spots.";
        }
    }

    public void waterPlants() throws IOException {
        //Loops through all the greenhouse plants.
        for (Plant plant : this.getPlantList()) {
            //Sets plant waterLevel to 5
            plant.addWaterLevel(5 - plant.getWaterLevel());
        }
        //log plants watered
        writeToLog("Plants watered.");
    }

    //Grows all greenhouse plants.
    public String growPlants() throws IOException {
        //Creates an instance of StringBuilder.
        StringBuilder plantsGrown = new StringBuilder();
        //Loops through all the greenhouse plants.
        for (Plant plant : this.getPlantList()) {
            //Checks if the plants have water
            if (plant.getWaterLevel() >= 1) {
                //Reduces plant waterLevel by one
                plant.addWaterLevel(-1);
                //Grows the plant by one unit.
                plant.addGrowth(1);
                //Sets the plant height based on plant stage.
                plant.setHeight(plant.getStage());
                //Builds a string with information on which plants have grown to a new stage.
                plantsGrown.append(plant.plantGrown());
            }
        }
        //Logs and returns plant grown information.
        writeToLog(plantsGrown.toString());
        return plantsGrown.toString();
    }

    //Adds lines to the log file.
    public void writeToLog(String textLine) throws IOException {
        //Creates an instance of the java FileWriter class.
        FileWriter write = new FileWriter("log.txt", true);
        //Creates an instance of the java PrintWriter class with the FileWriter as argument.
        PrintWriter printLine = new PrintWriter(write);
        //Prints the text-string in the log file.
        printLine.printf("%s" + "%n", textLine);
        printLine.close();
    }
}