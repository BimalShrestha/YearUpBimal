package com.dealership.demo.models.repositories;

import com.dealership.demo.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalesRepository {

    private final DataSource dataSource;
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    public SalesRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
   public List<SalesContract> getAllSalesContract(){
        String query = "SELECT * FROM Sales_contracts";
        List<SalesContract> salesContracts = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query) ){
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                   var saleContract = new SalesContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")),rs.getBoolean("isFinanced"));
                   salesContracts.add(saleContract);

            }


        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return salesContracts;
    }

    public List<SalesContract> getByDate(Date startDate, Date endDate){
        String query = "SELECT * FROM Sales_contracts WHERE dateOfContract BETWEEN ? AND ? ";
        List<SalesContract> salesContracts = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)){
            ps.setDate(1,startDate);
            ps.setDate(2,endDate);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var saleContract = new SalesContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")),rs.getBoolean("isFinanced"));
                salesContracts.add(saleContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return salesContracts;
    }

    public List<SalesContract> getByCustomerName(String name){
        String query = "SELECT * FROM Sales_contracts WHERE customerName LIKE ? ";
        List<SalesContract> salesContracts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var saleContract = new SalesContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")),rs.getBoolean("isFinanced"));
                salesContracts.add(saleContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return salesContracts;


    }

    public List<SalesContract> getByCustomerEmail(String email){
        String query = "SELECT * FROM Sales_contracts WHERE customerEmail LIKE ? ";
        List<SalesContract> salesContracts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,"%"+email+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var saleContract = new SalesContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")),rs.getBoolean("isFinanced"));
                salesContracts.add(saleContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return salesContracts;


    }

    public List<SalesContract> getByIsFinanced(boolean isFinanced){
        String query = "SELECT * FROM Sales_contracts WHERE IsFinanced = ? ";
        List<SalesContract> salesContracts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setBoolean(1,isFinanced);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var saleContract = new SalesContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")),rs.getBoolean("isFinanced"));
                salesContracts.add(saleContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return salesContracts;


    }

    public void createSalesContract(SalesContract salesContract, int dealership_id){
        String query = "INSERT INTO Sales_contracts(dateOfContract, customerName, customerEmail, isFinanced, vin, dealership_id) VALUES (?,?,?,?,?,?)";

        try(Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){

            ps.setDate(1,Date.valueOf(salesContract.getDateOfContract()));
            ps.setString(2,salesContract.getCustomerName());
            ps.setString(3,salesContract.getCustomerEmail());
            ps.setBoolean(4,salesContract.isFinanced());
            ps.setString(5,salesContract.getVehicleSold().getVin());
            ps.setInt(6,dealership_id);

            ps.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }



}
