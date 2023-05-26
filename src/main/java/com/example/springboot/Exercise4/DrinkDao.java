package com.example.springboot.Exercise4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DrinkDao {
    private List<Drink> drinks = new ArrayList<>();

    public void addDrink(Drink d) {
        drinks.add(d);
    }

    public void removeDrink(String name) {
        List<Drink> tempList = drinks.stream().filter(listD -> listD.getName().equals(name)).collect(Collectors.toList());
        if (tempList.size() == 1) {
            drinks.remove(tempList.get(0));
        } else if (tempList.size() == 0) {
            System.out.println("Drink not found.");
        } else System.err.println("More thank one drink found, ask the programmer for a  delete function with RequestBody");
    }

    public void updateDrink(Drink d) {
        drinks.removeIf(listD -> listD.getName().equals(d.getName()));
        drinks.add(d);
    }

    public List<Drink> getDrinks() {
        return this.drinks;
    }
}
