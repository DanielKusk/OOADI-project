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
    private int prevStage;

    //This is the constructor
    public Plant(int stage) {
        this.stage = stage;
        this.growth = 20 * stage;
        this.waterLevel = 5;
        this.growTime = 6;
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

    //These are methods
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = this.waterLevel + waterLevel;
    }

    public void setStage(double growth) {
        this.stage = (int) this.growth / 20;
    }

    public void addGrowth(double growth) {
        this.prevStage = this.getStage();
        if (this.stage != 5) {
            this.growth = min(this.growth + growth * 100 / this.growTime, 100);
            this.setStage(this.growth);
        }
    }

    public String plantGrown() {
        if (this.getStage() > this.getPrevStage()) {
            return this.getClass().getSimpleName() + " has grown to stage: " + this.getStage() + "\r\n";
        } else {
            return "";
        }
    }
}


