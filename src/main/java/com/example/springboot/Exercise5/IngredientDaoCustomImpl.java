package com.example.springboot.Exercise5;
import java.util.NoSuchElementException;

public class IngredientDaoCustomImpl implements IngredientDaoCustom{

    // Purtroppo mi tocca mettere ingredientDao come parametro della funzione, perché se uso @Autowired mi dà errore per
    // dipendenza ciclica, se non lo metto non posso accedere al repository da qui
    @Override
    public void updateById(IngredientDao ingredientDao, Ingredient ingredient, Long ingredientId){
        Ingredient ingredientRepo = ingredientDao.findById(ingredientId).orElseThrow(NoSuchElementException::new);
        ingredientRepo.setName(ingredient.getName());
        ingredientRepo.setIsGlutenFree(ingredient.isGlutenFree());
        ingredientRepo.setIsVegetarian(ingredient.isVegetarian());
        ingredientRepo.setIsVegan(ingredient.isVegan());
        ingredientRepo.setIsLactoseFree(ingredient.isLactoseFree());

        ingredientDao.save(ingredientRepo);
    }
}
