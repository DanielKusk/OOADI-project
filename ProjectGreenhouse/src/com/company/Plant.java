//package com.company;
//import static java.lang.Math.*;
//
//enum typeEnum{Lemon, BabyCucumber, Tomato, Grape, BellPepper, Squash,;}
////enum resilienceEnum {
////    degree1(1), degree2(2), degree3(3), degree4(4);
////    private int degree;
////    resilienceEnum(int degree) {
////        this.degree = degree;
////    }
////}
////enum soilTypeEnum {
////    citrus(1), neutral(2), nutrientRichSoil(3);
////    private int soil;
////    soilTypeEnum(int soil) {
////        this.soil = soil;
////    }
////}
//
//public class Plant extends Greenhouse {
//    private typeEnum type;
//    private int heightCm;
//    private int maxHeightCm;
//    private int growTime;
//    private double growth;
//    private int stage;
//    private int temperature = getTemperature();
//    private boolean sunlight = getSunlight();
//    private int waterLevel;
////    private resilienceEnum resilience;
////    private int humidityRequirementsPercent;
////    private soilTypeEnum soilType;
//
//    public Plant(typeEnum type, int stage) {
//        this.type = type;
//        this.stage = stage;
//        this.growth = 20 * stage;
//        this.plantSelector(type, stage);
//    }
//
//    public void plantSelector(typeEnum type, int stage) {
//        if (this.type == typeEnum.Lemon) {
//            this.setGrowTime(40);
//            this.setMaxHeightCm(120);
//            this.setWaterLevel(500);
////            this.setResilience(resilienceEnum.degree1);
////            this.setSoilType(soilTypeEnum.citrus);
////            this.setHumidityRequirementsPercent(80);
//        } else if(this.type == typeEnum.BabyCucumber) {
//            this.setGrowTime(40);
//            this.setMaxHeightCm(160);
//            this.setWaterLevel(375);
////            this.setResilience(resilienceEnum.degree2);
////            this.setSoilType(soilTypeEnum.neutral);
////            this.setHumidityRequirementsPercent(60);
//        } else if(this.type == typeEnum.Tomato) {
//            this.setGrowTime(40);
//            this.setMaxHeightCm(190);
//            this.setWaterLevel(520);
////            this.setResilience(resilienceEnum.degree4);
////            this.setSoilType(soilTypeEnum.neutral);
////            this.setHumidityRequirementsPercent(60);
//        } else if(this.type == typeEnum.Grape) {
//            this.setGrowTime(60);
//            this.setMaxHeightCm(240);
//            this.setWaterLevel(400);
////            this.setResilience(resilienceEnum.degree2);
////            this.setSoilType(soilTypeEnum.neutral);
////            this.setHumidityRequirementsPercent(60);
//        } else if(this.type == typeEnum.BellPepper) {
//            this.setGrowTime(60);
//            this.setMaxHeightCm(180);
//            this.setWaterLevel(300);
////            this.setResilience(resilienceEnum.degree3);
////            this.setSoilType(soilTypeEnum.neutral);
////            this.setHumidityRequirementsPercent(60);
//        } else if(this.type == typeEnum.Squash) {
//            this.setGrowTime(20);
//            this.setMaxHeightCm(100);
//            this.setWaterLevel(220);
////            this.setResilience(resilienceEnum.degree3);
////            this.setSoilType(soilTypeEnum.nutrientRichSoil);
////            this.setHumidityRequirementsPercent(50);
//        }
//    }
//
//    public void growPlants() {
//        if ((sunlight = true) & (temperature > 10)) {
//            setGrowth(1);
//        }
//    }
//    private void setGrowTime(int growTime) {
//        this.growTime = growTime;
//    }
//    private void setMaxHeightCm(int maxHeightCm) {
//        this.maxHeightCm = maxHeightCm;
//    }
//    private void setWaterLevel(int waterLevel) {
//        this.waterLevel = waterLevel;
//    }
//    //    private void setResilience(resilienceEnum resilience) {
//    //        this.resilience = resilience;
//    //    }
//    //    private void setSoilType(soilTypeEnum soilType) {
//    //        this.soilType = soilType;
//    //    }
////    private void setHumidityRequirementsPercent(int humidityRequirementsPercent) {
////        this.humidityRequirementsPercent = humidityRequirementsPercent;
////    }
//    public void setGrowth(double growth) {
//        this.growth = min(this.growth + growth * 100 / growTime, 100);
//        setStage(this.growth);
//    }
//    public void setStage(double growth){
//        if ((growth == 100 ) & (this.stage != 5)) {
//            this.stage = 5;
//        }
//        else if ((growth >= 80 ) & (this.stage != 4)) {
//            this.stage = 4;
//        }
//        else if ((growth >= 60) & (this.stage != 3)) {
//            this.stage = 3;
//        }
//        else if ((growth >= 40) & (this.stage != 2)) {
//            this.stage = 2;
//        }
//        else if ((growth >= 20) & (this.stage != 1)) {
//            this.stage = 1;
//        }
//        else {
//            this.stage = 0;
//        }
//    }
//
//    public typeEnum getType() {
//        return type;
//    }
//    public int getHeightCm() {
//        return heightCm;
//    }
//    public int getGrowTime() {
//        return growTime;
//    }
//    public int getStage() {
//        return stage;
//    }
//    public double getGrowth() {
//        return growth;
//    }
//    public int getWaterLevel() {
//        return waterLevel;
//    }
////    set waterLevel() {
////        this.waterLevel = 5;
////    }
////    public int getHumidityRequirementsPercent() {
////        return humidityRequirementsPercent;
////    }
////
////    public resilienceEnum getResilience() {
////        return resilience;
////    }
////    public soilTypeEnum getSoilType() {
////        return soilType;
////    }
//}
//
//
