package com.company.server;

import static java.lang.Math.*;
//This is the class
public class Plant {
    //These are the attributes
    public double growth;
    private int stage;
    private int waterLevel;
    public int growTime;
    //This is the constructor
    public Plant(int stage) {
        this.stage = stage;
        this.growth = 20 * stage;
        this.waterLevel = 5;
        this.growTime = 6;
    }
    //These are methods
    private void setWaterLevel(int waterLevel) {
        this.waterLevel = this.waterLevel + waterLevel;
    }

    public void setStage(double growth) {
        if ((growth == 100) & (this.stage != 5)) {
            this.stage = 5;
        } else if ((growth >= 80) & (this.stage != 4)) {
            this.stage = 4;
        } else if ((growth >= 60) & (this.stage != 3)) {
            this.stage = 3;
        } else if ((growth >= 40) & (this.stage != 2)) {
            this.stage = 2;
        } else if ((growth >= 20) & (this.stage != 1)) {
            this.stage = 1;
        } else {
            this.stage = 0;
        }
    }

    public int getStage() {
        return stage;
    }

    public double getGrowth() {
        return growth;
    }

    public int getGrowTime(){
        return growTime;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setGrowth(double growth) {
        this.growth = min(this.growth + growth * 100 / growTime, 100);
        setStage(this.growth);
    }

    public void growPlants() {
        if (this.getWaterLevel() > 0) {
            setGrowth(1);
        }
    }
}


