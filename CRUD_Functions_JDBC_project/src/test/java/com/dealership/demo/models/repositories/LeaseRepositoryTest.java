package com.dealership.demo.models.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
class LeaseRepositoryTest {

    @Autowired
    private LeaseRepository leaseRepository;

    @Test
    void getAllSalesContract() {
        var leaseContracts = leaseRepository.getAllLeaseContract();

        assertEquals(10,leaseContracts.size());

    }

    @Test
    void getByDate() {
        var leaseContracts = leaseRepository.getByDate(Date.valueOf("2020-10-10"),Date.valueOf("2023-06-18"));

        assertEquals(5, leaseContracts.size());
    }

    @Test
    void getByCustomerName() {
        var leaseContracts = leaseRepository.getByCustomerName("i");

        assertEquals(6,leaseContracts.size());
    }

    @Test
    void getByCustomerEmail() {
        var leaseContracts = leaseRepository.getByCustomerEmail("davis");

        assertEquals(1, leaseContracts.size());
    }

}