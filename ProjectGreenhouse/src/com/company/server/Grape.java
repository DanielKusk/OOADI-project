package com.company.server;

public class Grape extends Plant {
    private int stage;
    private final int maxHeight;

    public Grape(int stage) {
        super(stage);
        this.maxHeight = 240;
        this.setHeight(stage);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setHeight(int stage) {
        if (stage == 0) {
            this.height = 0;
        } else {
            this.height = this.getMaxHeight() / (6 - this.stage);
        }
    }
}