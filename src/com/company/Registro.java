package com.company;

public class Registro {

    private String day;
    private Double maxTemp;
    private Double minTemp;
    private Double difTemp;

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

    public String getDay() {
        return this.day;
    }

    public Double getMaxTemp() {
        return this.maxTemp;
    }

    public Double getMinTemp() {
        return this.minTemp;
    }

    public Double getDifTemp() {
        return this.difTemp;
    }
}
