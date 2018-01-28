package com.paulina.sandboxandroid;

/**
 * Created by Paulina Kruża on 2017-10-11.
 */

public class Ingredient {
    private String  name;
    private Double  quantity;
    private String  unit;
    private Double amount;
    private Double  calorie;

    public Ingredient(String name, Double quantity, String unit, Double amount, Double calorie) {
        this.name     = name;
        this.quantity = quantity;
        this.unit     = unit;
        this.amount   = amount;
        this.calorie  = calorie;
    }

    public Ingredient() {
        this("", 0.0, "", 0.0, 0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }


    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", quantity=" + quantity
                + ", unit=" + unit + ", amount=" + amount + ", calorie="
                + calorie + "]";
    }

}
