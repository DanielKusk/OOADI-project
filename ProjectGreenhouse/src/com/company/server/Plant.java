package com.company.server;

import static java.lang.Math.*;

//This is the class
public class Plant {
    //These are the attributes
    public double growth;
    private int stage;
    private int waterLevel;
    public int growTime;
    public int height;
    public int maxHeight;
    private int prevStage;

    //This is the constructor
    public Plant() {
        this.stage = 0;
        this.growth = 0;
        this.waterLevel = 5;
        this.growTime = 6;
    }

    //These are methods
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

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = this.waterLevel + waterLevel;
    }

    public void setStage() {
        this.stage = (int) this.growth / 20;
    }

    public void setHeight(int stage) {
        if (stage == 0) {
            this.height = 0;
        } else {
            this.height = this.getMaxHeight() / (6 - this.stage);
        }
    }

    public void addGrowth(double growth) {
        this.prevStage = this.getStage();
        if (this.stage != 5) {
            this.growth = min(this.growth + growth * 100 / this.growTime, 100);
            this.setStage();
        }
    }

    public String plantGrown() {
        if (this.getStage() > this.getPrevStage()) {
            return this.getClass().getSimpleName() + " has grown to stage: " + this.getStage() + " and is now " + this.getHeight() + " tall.\r\n";
        } else {
            return "";
        }
    }
}


