package com.company.server;

public class Lemon extends Plant {
    private int stage;

    public Lemon(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 120;
        this.setHeight(stage);
    }
}