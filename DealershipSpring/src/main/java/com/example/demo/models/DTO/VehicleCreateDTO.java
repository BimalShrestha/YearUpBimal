package com.example.demo.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VehicleCreateDTO {
    @NotBlank
    private String vin;
    @NotNull
    private int year;
    @NotNull
    @Size(min = 2, max = 50)
    private String make;
    @NotNull
    @Size(min = 2, max = 50)
    private String model;
    @NotNull
    @Size(min = 2, max = 50)
    private String vehicleType;
    @NotNull
    @Size(min = 2, max = 50)
    private String color;
    @NotNull
    private int odometer;
    @NotNull
    private double price;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
