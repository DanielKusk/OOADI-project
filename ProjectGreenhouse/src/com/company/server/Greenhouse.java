package com.company.server;
import java.util.ArrayList;
import java.util.List;

public class Greenhouse {
    private List<Plant> plantList = null;
    private int totalSpots;
    private int vacantSpots;

    public Greenhouse() {
        this.totalSpots = 15;
        this.plantList = new ArrayList<Plant>();
        this.setVacantSpots();
    }

    public int getVacantSpots() {
        return vacantSpots;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void addVacantSpots(int number) {
        vacantSpots = vacantSpots + number;
    }

    private void setVacantSpots() {
        vacantSpots = totalSpots - plantList.size();
    }

    public void addPlant(String type, int stage){
        switch (type){
            case "Lemon" -> {
                plantList.add(new Lemon(stage));
            }
            case "BabyCucumber" -> {
                plantList.add(new BabyCucumber(stage));
            }
            case "BellPepper" -> {
                plantList.add(new BellPepper(stage));
            }
            case "Grape" -> {
                plantList.add(new Grape(stage));
            }
            case "Tomato" -> {
                plantList.add(new Tomato(stage));
            }
        }
        this.addVacantSpots(-1);
    }
}