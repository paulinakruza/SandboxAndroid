package com.paulina.sandboxandroid;

/**
 * Created by Paulina Kruża on 2017-10-11.
 */

/* TODO: enum jest bardzo odradzany w Androidzie - doczytać i skasować enum*/
public enum MealType {
    BREAKFAST("Śniadanie"),
    ELEVENSES("Drugie śniadanie"),
    LUNCH("Lunch"),
    DINNER("Obiad"),
    SUPPER("Kolacja");

    private String name;

    MealType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
