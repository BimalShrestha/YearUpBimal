package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
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

    @ManyToMany(mappedBy = "vehicles")
    @JsonIgnore
    private Set<Dealership> dealerships = new HashSet<>();

    public Vehicle() {
    }

    public Vehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Set<Dealership> getDealerships() {
        return dealerships;
    }

    public void setDealerships(Set<Dealership> dealerships) {
        this.dealerships = dealerships;
    }

    @Override
    public String toString(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",vin,year,make,model,vehicleType,color,odometer,price);
    }
}
