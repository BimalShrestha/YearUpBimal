package com.dealership.demo.models.repositories;

import com.dealership.demo.models.LeaseContract;
import com.dealership.demo.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeaseRepository {

    private final DataSource dataSource;
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    public LeaseRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public List<LeaseContract> getAllLeaseContract(){
        String query = "SELECT * FROM Lease_contracts";
        List<LeaseContract> leaseContracts = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query) ){
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                var leaseContract = new LeaseContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")));
                leaseContracts.add(leaseContract);

            }


        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return leaseContracts;
    }

    public List<LeaseContract> getByDate(Date startDate, Date endDate){
        String query = "SELECT * FROM Lease_contracts WHERE dateOfContract BETWEEN ? AND ? ";
        List<LeaseContract> leaseContracts = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setDate(1,startDate);
            ps.setDate(2,endDate);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var leaseContract = new LeaseContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")));
                leaseContracts.add(leaseContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return leaseContracts;
    }

    public List<LeaseContract> getByCustomerName(String name){
        String query = "SELECT * FROM Lease_contracts WHERE customerName LIKE ? ";
        List<LeaseContract> leaseContracts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var leaseContract = new LeaseContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")));
                leaseContracts.add(leaseContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return leaseContracts;


    }

    public List<LeaseContract> getByCustomerEmail(String email){
        String query = "SELECT * FROM Lease_contracts WHERE customerEmail LIKE ? ";
        List<LeaseContract> leaseContracts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,"%"+email+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var leaseContract = new LeaseContract(rs.getDate("dateOfContract").toLocalDate(),rs.getString("customerName"),rs.getString("customerEmail"),vehicleRepository.getVehiclesByVin(rs.getString("vin")));
               leaseContracts.add(leaseContract);

            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return leaseContracts;


    }
}
