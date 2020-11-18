package com.company.server;

public class BabyCucumber extends Plant {
    private int height;
    private int maxHeight;

    public BabyCucumber(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 160;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public int getMaxHeight(){
        return maxHeight;
    }
}