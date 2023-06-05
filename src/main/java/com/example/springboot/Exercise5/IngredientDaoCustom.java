package com.example.springboot.Exercise5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface IngredientDaoCustom extends JpaRepository<Ingredient, Long> {
    void updateById(Ingredient ingredient, Long ingredientId) throws SQLException;
}
