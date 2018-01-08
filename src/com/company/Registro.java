package com.company;

public class Registro {

    public String getDay() {
        return day;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public Double getDifTemp() {
        return difTemp;
    }

    private String day = null;
    private Double maxTemp = null;
    private Double minTemp = null;
    private Double difTemp = null;

    public Registro(String day, Double maxTemp, Double minTemp, Double difTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.difTemp = difTemp;
    }

    public Registro() {
        this.day = null;
        this.maxTemp = null;
        this.minTemp = null;
        this.difTemp = null;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public void setDifTemp(Double difTemp) {
        this.difTemp = difTemp;
    }
}
