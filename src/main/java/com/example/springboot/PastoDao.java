package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PastoDao extends JpaRepository<Pasto, Integer> {
    // -----------------------------------------------------------------------------------------------------------------
    // Esercizio Where in Hibernate    ---------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    // Query 1
    List<Pasto> findByDescription(String description);
    // Query 2
    List<Pasto> findByPriceLessThan(Double price);
    // Query 3
    List<Pasto> findByPriceBetween(Double minPrice, Double maxPrice);
    // Query 4
    List<Pasto> findByDescriptionAndPriceLessThan(String description, Double price);

    // Test a caso
    List<Pasto> findByDescriptionContains(String word);
    List<Pasto> findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(Double maxPrice, Integer minCalories, Integer maxCalories);

    // ESERCIZIO 6 __________________________________________________________ //

    List<Pasto> findByIsWinterMeal(boolean isWinterMeal);
}
