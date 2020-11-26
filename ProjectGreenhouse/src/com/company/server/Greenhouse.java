package com.company.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

//The greenhouse contains and manages the plants.
public class Greenhouse {
    private int day = 1;
    private final int totalSpots = 15;
    private int vacantSpots;
    private final List<Plant> plantList;
    private final PlantFactory factory;
    private final Logger logger;

    //Greenhouse constructor.
    public Greenhouse(PlantFactory factory) throws IOException {
        this.plantList = new ArrayList<>();
        this.setVacantSpots();
        this.factory = factory;
        logger = Logger.getLogger();
        logger.writeToLog("Day: " + this.day);
    }

    public int getVacantSpots() {
        return this.vacantSpots;
    }

    public int getTotalSpots() {
        return this.totalSpots;
    }

    public List<Plant> getPlantList() {
        return this.plantList;
    }

    //Generates overview of Greenhouse and returns this as a string.
    public String getOverview() {
        StringBuilder overview = new StringBuilder();

        overview.append("Vacant spots: ");
        overview.append(this.getVacantSpots());
        overview.append(" of ");
        overview.append(this.getTotalSpots());
        overview.append(".\r\n");

        for (Plant plant : this.getPlantList()) {
            overview.append(plant.getOverview());
        }
        return overview.toString();
    }

    private void setVacantSpots() {
        this.vacantSpots = totalSpots - plantList.size();
    }

    //Goes to the next day and logs the new day.
    public void nextDay() {
        this.day++;
        logger.writeToLog("\r\nDay: " + this.day);
    }

    //Adds a new plant to the greenhouse and logs the event.
    public String addPlant(String type) {
        if (this.getVacantSpots() >= 1) {
            //Requests new plant from PlantFactory.
            plantList.add(factory.getPlant(type));
            setVacantSpots();
            logger.writeToLog("New " + type + " stage 0 added. Vacant spots: " + this.getVacantSpots() +
                    " of " + this.getTotalSpots() + ".");
            return "New " + type + " stage 0 added. Vacant spots: " + this.getVacantSpots() +
                    " of " + this.getTotalSpots() + ".";
        } else {
            return "No more vacant spots.";
        }
    }

    //Adds water to Greenhouse plants and logs the event.
    public void waterPlants() {
        for (Plant plant : this.getPlantList()) {
            plant.addWaterLevel(5 - plant.getWaterLevel());
        }
        logger.writeToLog("Plants watered.");
    }

    //Grows all greenhouse plants and logs events.
    public String growPlants() {
        StringJoiner plantsGrown = new StringJoiner("\r\n");

        for (Plant plant : this.getPlantList()) {
            if (plant.getWaterLevel() >= 1) {
                plant.addWaterLevel(-1);
                plant.addGrowth(1);
                plant.setHeight(plant.getStage());
                String plantGrowth = plant.plantGrown();
                if (!plantGrowth.isEmpty()){
                    plantsGrown.add(plantGrowth);
                }
            }
        }

        //Logs and returns plant grown information.
        logger.writeToLog(plantsGrown.toString());
        return plantsGrown.toString();
    }
}