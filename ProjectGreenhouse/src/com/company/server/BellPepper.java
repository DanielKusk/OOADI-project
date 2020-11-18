package com.company.server;

public class BellPepper extends Plant {
    private int height;
    private int maxHeight;

    public BellPepper(int stage) {
        super(stage);
        this.maxHeight = 180;
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

