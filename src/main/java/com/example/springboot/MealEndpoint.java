package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealEndpoint {
    private List<Meal> cibooo = Arrays.asList(
            new Meal("Hamburger", "Beef patty with bacon, cheddar cheese and Kaiser bread", 15.50),
            new Meal("Pizza", "Pizza dough with mozzarella cheese and tomato sauce", 8.50),
            new Meal("Risotto", "White rice with onions ans saffron",  5.40)
    );

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> menu() {
        return ResponseEntity.ok(cibooo);
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> mealByName(@PathVariable("name") String name) {
        for (Meal m : cibooo) {
            if (m.getName().equals(name)) {
                return ResponseEntity.ok(m);
            }
        }
        return ResponseEntity.badRequest().body("No such meal at present");
    }

    @GetMapping("meal/description-match/{description}")
    public ResponseEntity<?> mealByDescription(@PathVariable("description") String description) {
        List<Meal> returnList = new ArrayList<>();
        for (Meal m : cibooo) {
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
        List<Meal> returnList = new ArrayList<>();
        for (Meal m : cibooo) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No meal matches the price range");
        }
        else return ResponseEntity.ok(returnList);
    }
}
