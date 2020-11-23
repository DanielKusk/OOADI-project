package com.company.server;

public class BabyCucumber extends Plant {
    private int stage;
    private final int maxHeight;

    public BabyCucumber(int stage) {
        super(stage);
        this.growTime = 4;
        this.maxHeight = 160;
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