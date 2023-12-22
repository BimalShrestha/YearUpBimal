package com.example.demo.models.repositories;

import com.example.demo.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByMakeContainingIgnoreCaseAndModelContainingIgnoreCase(String make, String model);
    List<Vehicle> findByVehicleTypeContainingIgnoreCase(String vehicleType);
    List<Vehicle> findByColorContainingIgnoreCase(String color);
    List<Vehicle> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Vehicle> findByOdometerBetween(int minMiles, int maxMiles);
    List<Vehicle> findByYearBetween(int minYear, int maxYear);

}
