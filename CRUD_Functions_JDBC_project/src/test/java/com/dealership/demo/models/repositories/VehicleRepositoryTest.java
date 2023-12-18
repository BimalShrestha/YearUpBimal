package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    void getAllVehicles_Succeeds() {
        // Arrange
        // ... (your setup code)

        // Act
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();

        // Assert
        int expectedCount = 20;
        assertEquals(expectedCount, vehicles.size(), "Unexpected number of vehicles");

    }
    @Test
    void getVehiclesByVin() {
        var vehicle = vehicleRepository.getVehiclesByVin("112233");

        assertEquals("Subaru", vehicle.getMake());
    }
    @Test
    void getVehiclesByPrice_Succeeds() {
     var vehicles = vehicleRepository.getVehiclesByPrice(20000,30000);

     assertEquals(13, vehicles.size());
    }

    @Test
    void getVehiclesByMakeModel() {
        var vehicles = vehicleRepository.getVehiclesByMakeModel("honda","civic");

        assertEquals(1,vehicles.size());
    }

    @Test
    void getVehiclesByYear() {
        var vehicles = vehicleRepository.getVehiclesByYear(2020,2022);

        assertEquals(11, vehicles.size());
    }

    @Test
    void getVehiclesByColor() {
        var vehicles = vehicleRepository.getVehiclesByColor("red");

        assertEquals(3,vehicles.size());
    }

    @Test
    void getVehiclesByMileage() {
        var vehicles = vehicleRepository.getVehiclesByMileage(30000,150000);

        assertEquals(1,vehicles.size());
    }

    @Test
    void getVehiclesByType() {
        var vehicles = vehicleRepository.getVehiclesByType("sedan");

        assertEquals(6, vehicles.size());
    }

    @Test
    void addVehicle() {
        vehicleRepository.addVehicle(new Vehicle("123",2011,"Honda","fit","suv","black",456466,12000));

        assertEquals(21, vehicleRepository.getAllVehicles().size());

    }

    @Test
    void removeVehicle() {
        vehicleRepository.removeVehicle("123");

        assertEquals(20, vehicleRepository.getAllVehicles().size());
    }
}