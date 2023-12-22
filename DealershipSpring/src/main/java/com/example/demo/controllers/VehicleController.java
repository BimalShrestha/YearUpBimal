package com.example.demo.controllers;

import com.example.demo.models.DTO.VehicleCreateDTO;
import com.example.demo.models.Vehicle;
import com.example.demo.models.VehicleSearchCriteria;
import com.example.demo.models.DTO.VehicleUpdateDTO;
import com.example.demo.models.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }
    @GetMapping("/search/color")
    public ResponseEntity<List<Vehicle>> getVehicleByColor(@ModelAttribute VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> foundVehicles = vehicleService.getVehicleByColor(vehicleSearchCriteria);
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @GetMapping("/search/miles")
    public ResponseEntity<List<Vehicle>> getVehicleByMiles(@ModelAttribute VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> foundVehicles = vehicleService.getVehicleByMiles(vehicleSearchCriteria);
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> foundVehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @GetMapping("/search/price")
    public ResponseEntity<List<Vehicle>> getVehicleByPrice(@ModelAttribute VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> foundVehicles = vehicleService.getVehicleByPrice(vehicleSearchCriteria.getMinPrice(),vehicleSearchCriteria.getMaxPrice());
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @GetMapping("/search/MakeModel")
    public ResponseEntity<List<Vehicle>> getVehicleByMakeModel(@ModelAttribute VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> foundVehicles = vehicleService.getVehicleByMakeModel(vehicleSearchCriteria);
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @GetMapping("/search/type")
    public ResponseEntity<List<Vehicle>> getVehicleByType(@ModelAttribute VehicleSearchCriteria vehicleSearchCriteria){
        List<Vehicle> foundVehicles = vehicleService.getVehicleByType(vehicleSearchCriteria);
        return new ResponseEntity<>(foundVehicles,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable int id){
        this.vehicleService.deleteVehicle(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody VehicleUpdateDTO vehicle, @PathVariable int id){
       var updatedVehicle =  this.vehicleService.updateVehicle(id,vehicle.getOdometer(),vehicle.getPrice());

        return new ResponseEntity<>(  updatedVehicle,HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle){
       var createdVehicle = this.vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(createdVehicle,HttpStatus.CREATED);
    }
}
