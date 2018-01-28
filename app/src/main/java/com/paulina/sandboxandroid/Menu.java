package com.paulina.sandboxandroid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Paulina Kruża on 2018-01-28.
 */

public class Menu {
    private List<Meal> meals;


    public Menu(List<Meal> meals) {
        this.meals = meals;
    }

    public Menu() {
        this(new ArrayList<Meal>());
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }


    public List<Meal> findMealsByType(MealType type) {
        //TODO:
        return meals;
        //return meals.stream().filter(p -> p.getType() == type).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Menu [meals=" + meals + "]";
    }
}
