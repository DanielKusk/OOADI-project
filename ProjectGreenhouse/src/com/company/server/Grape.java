package com.company.server;

public class Grape extends Plant {
    private int height;
    private int maxHeight;

    public Grape(int stage) {
        super(stage);
        this.maxHeight = 240;
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