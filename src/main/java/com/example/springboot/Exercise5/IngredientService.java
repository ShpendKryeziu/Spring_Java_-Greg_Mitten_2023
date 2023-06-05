package com.example.springboot.Exercise5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class IngredientService {
    private IngredientDaoCustom ingredientDaoCustom;
    private IngredientDaoCustomImpl ingredientDaoImpl;
    @Autowired
    public IngredientService(IngredientDaoCustom ingredientDaoCustom, IngredientDaoCustomImpl ingredientDaoImpl) {
        this.ingredientDaoCustom = ingredientDaoCustom;
        this.ingredientDaoImpl = ingredientDaoImpl;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDaoCustom.save(ingredient);
    }

    public Ingredient getIngredient(Long ingredientId) {
        return ingredientDaoCustom.findById(ingredientId).orElse(null);
    }

    public void updateIngredient(Ingredient ingredient, Long ingredientId) throws SQLException {
        ingredientDaoImpl.updateById(ingredient, ingredientId);
    }

    public void deleteIngredient(Long ingredientId) {
        ingredientDaoCustom.deleteById(ingredientId);
    }
}
