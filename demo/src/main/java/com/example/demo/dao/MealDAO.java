package com.example.demo.dao;
import com.example.demo.service.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDAO {
    private List<Meal> meals = new ArrayList<>();
    @RequestMapping("/api/meal")
    public Meal addMeal (Meal meal) {
        this.meals.add(meal);
        return meal;
    }
    @RequestMapping("/api/meal")
    public void updateMeal (Meal meal) {
        this.meals.removeIf(m->m.getName().equals(meal.getName()));
        this.meals.add(meal);
    }

    @RequestMapping("/api/meal")
    public void deleteMeal (String mealName) {
        this.meals.removeIf(m->m.getName().equals(mealName));
    }

    @RequestMapping("/api/meal")
    public  List<Meal> getMeals(){
        return this.meals;
    }
}
