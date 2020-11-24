package com.company.server;

public class BabyCucumber extends Plant {
    private int stage;

    public BabyCucumber(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 160;
        this.setHeight(stage);
    }
}