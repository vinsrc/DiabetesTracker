package com.project.uwm.mydiabitiestracker.Objects;

/**
 * Created by Anitha on 7/13/2017.
 */

public class FoodConsumedObject {
    private int food_id;
    private String username;
    private String typeOfFood;
    private int amountOfFood;
    private int protien;
    private int calories;
    private String fdate;
    private String ftime;
    public FoodConsumedObject(int t_foo_id, String username, String t_typeOfFood, int t_amountOfFood, int t_protien, int t_calories, String t_date, String t_time){
        setTypeOfFood(t_typeOfFood);
        setUsername(username);
        setAmountOfFood(t_amountOfFood);
        setProtien(t_protien);
        setCalories(t_calories);
        setTime(t_time);
        setDate(t_date);
        setFood_id(t_foo_id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFood_id() {
        return food_id;
    }
    public int getCalories() {
        return calories;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public int getProtien() {
        return protien;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public void setProtien(int protien) {
        this.protien = protien;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getDate() {
        return fdate;
    }

    public String getTime() {
        return ftime;
    }

    public void setDate(String date) {
        this.fdate = date;
    }

    public void setTime(String time) {
        this.ftime = time;
    }
}