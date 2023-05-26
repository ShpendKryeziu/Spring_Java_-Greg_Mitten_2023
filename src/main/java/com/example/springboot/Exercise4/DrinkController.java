package com.example.springboot.Exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrinkController {
    private DrinkService drinkService;
    private DrinkConfig drinkConfig;
    @Autowired
    public DrinkController(DrinkService drinkService, DrinkConfig drinkConfig){
        this.drinkService = drinkService;
        this.drinkConfig = drinkConfig;
    }

    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getDrinks() {
        return ResponseEntity.ok(drinkService.getDrinks());
    }

    @GetMapping("/drink-config")
    public ResponseEntity<DrinkConfig> getDrinkConfig() {
        return ResponseEntity.ok(drinkConfig);
    }

    @PostMapping("/drink")
    public ResponseEntity<String> addDrink(@RequestBody Drink d) {
        drinkService.addDrink(d);
        return ResponseEntity.ok("Drink added!");
    }

    @PutMapping("/drink")
    public ResponseEntity<String> updateDrink(@RequestBody Drink d) {
        drinkService.updateDrink(d);
        return ResponseEntity.ok("Drink updated!");
    }

    @DeleteMapping("/drink")
    public ResponseEntity<String> removeDrink(@RequestParam("name") String name){
        drinkService.removeDrink(name);
        return ResponseEntity.ok("Drink removed.");
    }
}
