package com.company.server;

public class Tomato extends Plant {
    private int stage;

    public Tomato(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 190;
        this.setHeight(stage);
    }
}