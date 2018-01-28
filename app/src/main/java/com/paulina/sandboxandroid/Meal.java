package com.paulina.sandboxandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulina Kruża on 2017-10-11.
 */

public class Meal {

    private MealType         type;
    private String           name;
    private List<Ingredient> ingredients;
    private String           recipe;

    public Meal (MealType type, String name, List<Ingredient> ingredients, String recipe) {
        this.type        = type;
        this.name        = name;
        this.ingredients = ingredients;
        this.recipe      = recipe;
    }

    public Meal() {
        this(null, "", new ArrayList<Ingredient>(), "");
    }


    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }


    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


    @Override
    public String toString() {
        return "\nMeal [type=" + type + ", name=" + name + ", ingredients="
                + ingredients + "]";
    }
}
