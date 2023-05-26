package com.example.springboot.Exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    private DrinkDao drinkDao;
    @Autowired
    public DrinkService(DrinkDao drinkDao) {
        this.drinkDao = drinkDao;
    }

    public void addDrink(Drink d) {
        drinkDao.addDrink(d);
    }

    public void removeDrink(String name) {
        drinkDao.removeDrink(name);
    }

    public void updateDrink(Drink d) {
        drinkDao.updateDrink(d);
    }

    public List<Drink> getDrinks() {
        return drinkDao.getDrinks();
    }
}
