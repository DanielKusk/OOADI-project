package com.company.server;

public class Grape extends Plant {
    private int stage;

    public Grape(int stage) {
        super(stage);
        this.maxHeight = 240;
        this.setHeight(stage);
    }
}