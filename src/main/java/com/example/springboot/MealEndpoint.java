package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealEndpoint {
    private List<Pasto> cibooo = new ArrayList<>(Arrays.asList(
            new Pasto("Hamburger", "Beef patty with bacon, cheddar cheese and Kaiser bread", 15.50),
            new Pasto("Pizza", "Pizza dough with mozzarella cheese and tomato sauce", 8.50),
            new Pasto("Risotto", "White rice with onions ans saffron",  5.40)
    ));

    @GetMapping("/meals")
    public ResponseEntity<List<Pasto>> menu() {
        return ResponseEntity.ok(cibooo);
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> mealByName(@PathVariable("name") String name) {
        for (Pasto m : cibooo) {
            if (m.getName().equals(name)) {
                return ResponseEntity.ok(m);
            }
        }
        return ResponseEntity.badRequest().body("No such meal at present");
    }

    @GetMapping("meal/description-match/{description}")
    public ResponseEntity<?> mealByDescription(@PathVariable("description") String description) {
        List<Pasto> returnList = new ArrayList<>();
        for (Pasto m : cibooo) {
            if (m.getDescription().contains(description)) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No meal matches the description");
        }
        else return ResponseEntity.ok(returnList);
    }

    @GetMapping("meal/price")
    public ResponseEntity<?> mealByPriceRange(
            @RequestParam("minimum") double min,
            @RequestParam("maximum") double max) {
        List<Pasto> returnList = new ArrayList<>();
        for (Pasto m : cibooo) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No meal matches the price range");
        }
        else return ResponseEntity.ok(returnList);
    }

    // ESERCIZIO 3 __________________________________________________________ //

    @PostMapping(value = "post/meal")
    public ResponseEntity<?> postMeal(@RequestBody Pasto pasto) {
        cibooo.add(pasto);
        return ResponseEntity.ok("Meal inserted!");
    }

    @PutMapping("put/meal/{name}")
    public ResponseEntity<?> putMeal(@PathVariable("name") String name, @RequestBody Pasto pasto) {
        cibooo.removeIf(m -> m.getName().equals(name));
        cibooo.add(pasto);
        return ResponseEntity.ok("Meal updated!");
    }

    @DeleteMapping("delete/meal/{name}")
    public ResponseEntity<?> deleteMeal(@PathVariable("name") String name) {
        cibooo.removeIf(m -> m.getName().equals(name));
        return ResponseEntity.ok("Meal deleted!");
    }

    @DeleteMapping("delete/meal/price/{price}")
    public ResponseEntity<?> deleteAbovePrice(@PathVariable("price") double price) {
        cibooo.removeIf(m -> m.getPrice()>price);
        return ResponseEntity.ok("Meals above "+price+"€ have been deleted");
    }

    @PutMapping("put/meal/{name}/price")
    public ResponseEntity<?> updateMealPrice(@PathVariable("name") String name, @RequestParam("price") double price) {
        for (Pasto m : cibooo) {
            if (m.getName().equals(name)) {
                m.setPrice(price);
            }
        }
        return ResponseEntity.ok("Price of "+name+" updated to "+price+"€!");
    }
}