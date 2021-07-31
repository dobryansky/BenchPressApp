package com.artem.benchpressapp;

public class Exercise {
    private String week;
    private String day;
    private String name;
    private String weight;
    private String sets;
    private String reps;

    public Exercise(String week, String day, String name, String weight, String sets, String reps) {
        this.week = week;
        this.day = day;
        this.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }
}
