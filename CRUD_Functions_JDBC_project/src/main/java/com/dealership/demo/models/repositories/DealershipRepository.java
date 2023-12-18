package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
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
public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Dealership> getAllDealerships(){
        String query = "SELECT * FROM dealerships";
        List<Dealership> dealerships = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query) ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                var dealership = new Dealership(rs.getString("name"), rs.getString("address"),rs.getString("phone"));
                dealerships.add(dealership);
            }

        }
        catch (SQLException exception  ){
            exception.printStackTrace();
        }
        return dealerships;
    }

    public Dealership getDealershipById(int id){
        String query = "SELECT * FROM dealerships WHERE dealership_id = ?";
        Dealership dealership = null;

        try(Connection conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             dealership = new Dealership(rs.getString("name"), rs.getString("address"),rs.getString("phone"));
            }

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return dealership;
    }

    public void createDealership(Dealership dealership){
        String query = "INSERT INTO Dealerships ( name, address, phone) VALUES (?,?,?)";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3,dealership.getPhone());

            ps.executeUpdate();

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void updateDealership(Dealership dealership, int id){
        String query = "UPDATE dealerships SET name = ?, address = ?, phone = ? WHERE dealership_id = ?";

        try(Connection conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3,dealership.getPhone());
            ps.setInt(4, id);

            ps.executeUpdate();
        }
    catch (SQLException exception){
            exception.printStackTrace();
    }
    }

    public void deleteDealership(int id){
        String query = "DELETE FROM dealerships WHERE dealership_id = ?";

        try(Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
