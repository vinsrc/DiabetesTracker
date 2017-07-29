package com.project.uwm.mydiabitiestracker.objects;

/**
 * Created by RWZ on 7/24/2017.
 */

public class ExerciseReadingObject {
    private int exercise_id;
    private String exercise_type;
    private int duration;
    private String date;
    private String time;

    public ExerciseReadingObject(int id, int duration, String exercise_type, String date, String time){
        setExerciseId(id);
        setDuration(duration);
        setExerciseType(exercise_type);
        setDate(date);
        setTime(time);
    }
    // Getters:
    public String getExerciseType() {
        return exercise_type;
    }

    public int getDuration() { return duration; }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // Setters:
    public void setExerciseType(String exercise_type) {this.exercise_type = exercise_type; }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setExerciseId(int exercise_id) { this.exercise_id = exercise_id; }
}



