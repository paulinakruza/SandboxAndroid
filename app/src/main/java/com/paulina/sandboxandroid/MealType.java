package com.paulina.sandboxandroid;

/**
 * Created by Paulina Kruża on 2017-10-11.
 */

/* TODO: enum jest bardzo odradzany w Androidzie - doczytać i skasować enum*/
public enum MealType {
    SNIADANIE("Śniadanie"),
    DRUGIE_SNIADANIE("Drugie śniadanie"),
    PRZEKASKA("Przekąska"),
    OBIAD("Obiad"),
    KOLACJA("Kolacja");

    private String name;

    private MealType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
