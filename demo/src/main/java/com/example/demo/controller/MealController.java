package com.example.demo.controller;

import com.example.demo.service.Meal;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/meal")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/get/meal")
    public ResponseEntity<List<Meal>> getMeals() {
        List<Meal> meals = mealService.getMeals();
        return ResponseEntity.ok(meals);
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok("Added Meal");
    }

    @PutMapping("/put/replace-meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok("updated Meal");
    }

    @DeleteMapping("/delete/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable("mealName") String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Deleted Meal");
    }
}






