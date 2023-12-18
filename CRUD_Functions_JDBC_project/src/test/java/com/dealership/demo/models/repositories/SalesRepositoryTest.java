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
class SalesRepositoryTest {
    @Autowired
    private SalesRepository salesRepository;

    @Test
    void getAllSalesContract() {
        var salesContracts = salesRepository.getAllSalesContract();

        assertEquals(10,salesContracts.size());

    }

    @Test
    void getByDate() {
        var salesContracts = salesRepository.getByDate(Date.valueOf("2020-10-10"),Date.valueOf("2023-06-18"));

        assertEquals(5, salesContracts.size());
    }

    @Test
    void getByCustomerName() {
        var salesContracts = salesRepository.getByCustomerName("i");

        assertEquals(6,salesContracts.size());
    }

    @Test
    void getByCustomerEmail() {
        var salesContracts = salesRepository.getByCustomerEmail("davis");

        assertEquals(1, salesContracts.size());
    }

    @Test
    void getByIsFinanced() {
        var salesContracts = salesRepository.getByIsFinanced(false);

        assertEquals(5,salesContracts.size());
    }
}