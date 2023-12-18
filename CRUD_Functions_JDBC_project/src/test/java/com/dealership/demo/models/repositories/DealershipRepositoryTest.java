package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
class DealershipRepositoryTest {
    @Autowired
    private DealershipRepository dealershipRepository;

    @Test
    void getAllDealerships() {
        var dealerships  = dealershipRepository.getAllDealerships();

        assertEquals(10,dealerships.size());
    }

    @Test
    void getDealershipById() {
        var dealerships = dealershipRepository.getDealershipById(1);

        assertEquals("ABC Motors", dealerships.getName());
    }

    @Test
    void createDealership() {
        dealershipRepository.createDealership(new Dealership("bucklao","4564654 bb lane","4564646456"));

        assertEquals(11, dealershipRepository.getAllDealerships().size());
    }

    @Test
    void updateDealership() {
        Dealership dealership = new Dealership("aaa","bbb","ccc");
        dealershipRepository.updateDealership(dealership,11);



        assertEquals(dealership.getName(),dealershipRepository.getDealershipById(11).getName());

    }

    @Test
    void deleteDealership() {
        dealershipRepository.deleteDealership(11);

        assertEquals(10,dealershipRepository.getAllDealerships().size());
    }
}