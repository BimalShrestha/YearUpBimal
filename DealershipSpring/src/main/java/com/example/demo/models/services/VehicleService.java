package com.example.demo.models.services;
//the different search methods


import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.models.Vehicle;
import com.example.demo.models.VehicleSearchCriteria;
import com.example.demo.models.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VehicleService {
    //inject the repository into the service

    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    //delete a vehicle
    public void deleteVehicle(int vehicleId){
        //or else throw means if it doens't find the vehicle
        //it will throw this exception
        var vehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
        this.vehicleRepository.deleteById(vehicleId);
    }
    public Vehicle updateVehicle(int vehicleId, int odometer, double price){
        var foundVehicleOptional = this.vehicleRepository.findById(vehicleId);

        if (foundVehicleOptional.isPresent()) {
            var foundVehicle = foundVehicleOptional.get();
            foundVehicle.setOdometer(odometer);
            foundVehicle.setPrice(price);
            var savedVehicle = this.vehicleRepository.save(foundVehicle);

            return savedVehicle;
        } else {
            throw new EntityNotFoundException("Vehicle not found");
        }
    }
    public Vehicle createVehicle(Vehicle vehicle){
        var vehicle2 = this.vehicleRepository.save(vehicle);
        return vehicle2;
    }
    public List<Vehicle> getAllVehicles(){
        var vehicles = this.vehicleRepository.findAll();
        return vehicles;
    }

    public List<Vehicle> getVehicleByPrice(BigDecimal minPrice, BigDecimal maxPrice){
        List<Vehicle> vehicles = this.vehicleRepository.findByPriceBetween(minPrice,maxPrice);
        return vehicles;
    }

    public List<Vehicle> getVehicleByColor(VehicleSearchCriteria searchCriteria){
        List<Vehicle> vehicles = this.vehicleRepository.findByColorContainingIgnoreCase(searchCriteria.getColor());
        return vehicles;

    }
    public List<Vehicle> getVehicleByMiles(VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> vehicles = this.vehicleRepository.findByOdometerBetween(vehicleSearchCriteria.getMinMiles(),vehicleSearchCriteria.getMaxMiles());
        return vehicles;
    }
    public List<Vehicle> getVehicleByMakeModel(VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> vehicles = this.vehicleRepository.findByMakeContainingIgnoreCaseAndModelContainingIgnoreCase(vehicleSearchCriteria.getMake(),vehicleSearchCriteria.getModel());
        return vehicles;
    }
    public List<Vehicle> getVehicleByType(VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> vehicles = this.vehicleRepository.findByVehicleTypeContainingIgnoreCase(vehicleSearchCriteria.getType());
        return vehicles;
    }






}
