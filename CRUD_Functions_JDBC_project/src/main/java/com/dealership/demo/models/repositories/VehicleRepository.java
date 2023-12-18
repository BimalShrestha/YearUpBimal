package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Vehicle;
import com.dealership.demo.models.config.DatabaseConfig;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VehicleRepository {
    //Dependency
    //Without this, we can't connect to the database
    private final DataSource dataSource;

    //Autowired says, go and get me a copy of this
    @Autowired
    public VehicleRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAllVehicles(){
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }
    public Vehicle getVehiclesByVin(String vin){
        String query ="SELECT * FROM Vehicles WHERE vin = ?";
        Vehicle vehicle = null;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,vin);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                 vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicle;
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        String query = "SELECT * FROM Vehicles WHERE price BETWEEN ? AND ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)){

            ps.setDouble(1,min);
            ps.setDouble(2,max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        String query = "SELECT * FROM Vehicles WHERE make = ? AND model = ?";
        List<Vehicle> vehicles  = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,make);
            ps.setString(2,model);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }



        }
        catch(SQLException exception){
                exception.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        String query = "SELECT * FROM Vehicles WHERE year BETWEEN ? AND ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,min);
            ps.setInt(2,max);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        String query = "SELECT * FROM Vehicles WHERE color = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
          PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,color);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        String query = "SELECT * FROM Vehicles WHERE odometer BETWEEN ? AND ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,min);
            ps.setInt(2,max);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        String query = "SELECT * FROM Vehicles WHERE vehicleType = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,vehicleType);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("vehicleType"),
                        rs.getString("color"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        String query = "INSERT INTO Vehicles (vin, year, make, model, vehicleType, color, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,vehicle.getVin());
            ps.setInt(2,vehicle.getYear());
            ps.setString(3, vehicle.getMake());
            ps.setString(4,vehicle.getModel());
            ps.setString(5,vehicle.getVehicleType());
            ps.setString(6,vehicle.getColor());
            ps.setInt(7,vehicle.getOdometer());
            ps.setDouble(8,vehicle.getPrice());

            ps.executeUpdate();

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }

    }

    public void removeVehicle(String vin){
        String query = "DELETE FROM Vehicles WHERE vin = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,vin);

            ps.executeUpdate();

        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}
