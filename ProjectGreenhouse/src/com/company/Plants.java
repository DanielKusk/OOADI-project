package com.company;

enum typeEnum{Lemon, BabyCucumber, Tomato, Grape, BellPepper, Squash,;}
enum resilienceEnum{
    degree1(1), degree2(2), degree3(3), degree4(4);
    private int degree;
    resilienceEnum(int degree){
        this.degree = degree;
    }
}
enum soilTypeEnum{
    citrus(1), neutral(2), nutrientRichSoil(3);
    private int soil;
    soilTypeEnum(int soil){
        this.soil = soil;
    }
}

public class Plants {
    private typeEnum type;
    private int heightCM;
    private int growTime;
    private soilTypeEnum soilType;
    private int waterRequirementsML;
    private int humidityRequirementsPercent;
    private resilienceEnum resilience;
    private int growth;
    private int stage;


    public Plants(typeEnum type, int stage){
        this.type = type;
        this.stage = stage;
        this.growth = 20 * stage;
        this.plantSelector(type, stage);
    }

    public void plantSelector(typeEnum type, int stage){
        if (this.type == typeEnum.Lemon){
            this.setGrowTime(20);
            this.setResilience(resilienceEnum.degree1);
            this.setSoilType(soilTypeEnum.citrus);
            this.setWaterRequirementsML(500);
            this.setHumidityRequirementsPercent(80);
        } else if(this.type == typeEnum.BabyCucumber){
            this.setGrowTime(45);
            this.setResilience(resilienceEnum.degree2);
            this.setSoilType(soilTypeEnum.neutral);
            this.setWaterRequirementsML(375);
            this.setHumidityRequirementsPercent(60);
        } else if(this.type == typeEnum.Tomato){
            this.setGrowTime(40);
            this.setResilience(resilienceEnum.degree4);
            this.setSoilType(soilTypeEnum.neutral);
            this.setWaterRequirementsML(520);
            this.setHumidityRequirementsPercent(60);
        } else if(this.type == typeEnum.Grape){
            this.setGrowTime(40);
            this.setResilience(resilienceEnum.degree2);
            this.setSoilType(soilTypeEnum.neutral);
            this.setWaterRequirementsML(400);
            this.setHumidityRequirementsPercent(60);
        } else if(this.type == typeEnum.BellPepper){
            this.setGrowTime(55);
            this.setResilience(resilienceEnum.degree3);
            this.setSoilType(soilTypeEnum.neutral);
            this.setWaterRequirementsML(300);
            this.setHumidityRequirementsPercent(60);
        } else if(this.type == typeEnum.Squash){
            this.setGrowTime(45);
            this.setResilience(resilienceEnum.degree3);
            this.setSoilType(soilTypeEnum.nutrientRichSoil);
            this.setWaterRequirementsML(220);
            this.setHumidityRequirementsPercent(50);
        }
    }

    private void setGrowTime(int growTime){
        this.growTime = growTime;
    }
    private void setResilience(resilienceEnum resilience){
        this.resilience = resilience;
    }
    private void setSoilType(soilTypeEnum soilType){
        this.soilType = soilType;
    }
    private void setWaterRequirementsML(int waterRequirementsML){
    this.waterRequirementsML = waterRequirementsML;
    }
    private void setHumidityRequirementsPercent(int humidityRequirementsPercent){
        this.humidityRequirementsPercent = humidityRequirementsPercent;
    }
    public void setGrowth(int growth){
        this.growth = this.growth + growth;
    }

    public typeEnum getType(){
        return type;
    }
    public int getHeightCM(){
        return heightCM;
    }
    public int getGrowTime(){
        return growTime;
    }
    public soilTypeEnum getSoilType(){
        return soilType;
    }
    public int getwaterRequirementsML(){
        return waterRequirementsML;
    }
    public int getHumidityRequirementsPercent(){
        return humidityRequirementsPercent;
    }
    public resilienceEnum getResilience(){
        return resilience;
    }
    public int getGrowth(){
        return growth;
    }
    public int getStage(){
        return stage;
    }
}


