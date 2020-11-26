package com.company.server;

import static java.lang.Math.*;

public abstract class Plant {
    private int stage;
    private int prevStage;
    private double growth;
    public int growTime = 6;
    private int waterLevel = 5;
    private int height;
    public int maxHeight;

    public Plant() {
    }

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

    //Creates a string with plant information.
    public String getOverview() {
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
        this.prevStage = this.getStage();
        if (this.stage != 5) {
            this.growth = min(this.growth + growth * 100 / this.growTime, 100);
            this.setStage();
        }
    }

    //Checks plant for stage change and returns a string of some updated plant attributes.
    public String plantGrown() {
        if (this.getStage() > this.getPrevStage()) {
            return this.getClass().getSimpleName() + " has grown to stage: " + this.getStage() + " and is now " + this.getHeight() + " tall.";
        } else {
            return "";
        }
    }
}


