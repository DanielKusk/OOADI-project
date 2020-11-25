package com.company.server;

import static java.lang.Math.*;

public class Plant {
    //Plant attributes
    private int stage;
    private int prevStage;
    public double growth;
    public int growTime;
    private int waterLevel;
    public int height;
    public int maxHeight;

    //Plant constructor
    public Plant() {
        this.stage = 0;
        this.growth = 0;
        this.waterLevel = 5;
        this.growTime = 6;
    }

    //Plant getter methods.
    public int getStage() {
        return this.stage;
    }

    public int getPrevStage() {
        return this.prevStage;
    }

    public int getWaterLevel() {
        return this.waterLevel;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String getOverview() {
        //Creates a string with plant information.
        return "Type: " + this.getClass().getSimpleName() + ", Stage: " + this.getStage() +
                ", Water level: " + this.getWaterLevel() + ", Height: " + this.getHeight() + "\r\n";
    }

    //Plant setter methods
    public void addWaterLevel(int waterLevel) {
        this.waterLevel = this.waterLevel + waterLevel;
    }

    //Sets plant stage based on plant growth.
    public void setStage() {
        this.stage = (int) this.growth / 20;
    }

    //Sets plant height based on stage.
    public void setHeight(int stage) {
        if (stage == 0) {
            this.height = 0;
        } else {
            this.height = this.getMaxHeight() / (6 - this.stage);
        }
    }

    //Grows plant.
    public void addGrowth(double growth) {
        //Updates the previous stage for stage change check.
        this.prevStage = this.getStage();
        //Checks if the plant is already fully grown.
        if (this.stage != 5) {
            //Updates plant growth based on growTime.
            this.growth = min(this.growth + growth * 100 / this.growTime, 100);
            //Updates the plant stage.
            this.setStage();
        }
    }

    //Checks plant for stage change and returns a string of some updated plant attributes.
    public String plantGrown() {
        if (this.getStage() > this.getPrevStage()) {
            return this.getClass().getSimpleName() + " has grown to stage: " + this.getStage() + " and is now " + this.getHeight() + " tall.\r\n";
        } else {
            return "";
        }
    }
}


