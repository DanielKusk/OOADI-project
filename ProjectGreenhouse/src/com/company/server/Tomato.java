package com.company.server;

public class Tomato extends Plant {
    private int height;
    private int maxHeight;

    public Tomato(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 190;
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