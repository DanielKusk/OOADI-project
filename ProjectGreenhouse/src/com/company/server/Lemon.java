package com.company.server;

public class Lemon extends Plant {
    private int height;
    private int maxHeight;

    public Lemon(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 120;
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