package com.example.demo.models;

import java.math.BigDecimal;

public class VehicleSearchCriteria {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String make;
    private String model;
    private int minYear;
    private int maxYear;
    private String color;
    private int minMiles;
    private int maxMiles;
    private String type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinMiles() {
        return minMiles;
    }

    public void setMinMiles(int minMiles) {
        this.minMiles = minMiles;
    }

    public int getMaxMiles() {
        return maxMiles;
    }

    public void setMaxMiles(int maxMiles) {
        this.maxMiles = maxMiles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
