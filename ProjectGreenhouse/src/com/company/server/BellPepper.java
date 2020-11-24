package com.company.server;

public class BellPepper extends Plant {
    private int stage;

    public BellPepper(int stage) {
        super(stage);
        this.maxHeight = 180;
        this.setHeight(stage);
    }
}