package com.example.demo.controller;
import com.example.demo.service.Meal;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController

public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService){
        this.mealService=mealService;
    }
    @GetMapping("/get/meals")
    public ResponseEntity <List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PostMapping(value = "/post/replace-meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return  ResponseEntity.ok("Update Meal");
    }

    @PutMapping("/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){

        mealService.addMeal(meal);
        return ResponseEntity.ok("Aggiunto Meal");
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Cancellato Meal");
    }
}