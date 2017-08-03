package com.project.uwm.mydiabitiestracker.Objects;

/**
 * Created by RWZ on 7/30/2017.
 */
public class RegimenReadingObject {
    private int regimen_id;
    private String username;
    private String doctor;
    private String testedBGL;
    private String targetBGL;
    private String exercise;
    private String meds;
    private String diet;
    private String date;
    private String time;

    public RegimenReadingObject(int id, String username, String dr, String tested, String target, String exercise, String meds, String diet,String date, String time) {
        setRegimenId(id);
        setUsername(username);
        setDoctor(dr);
        setTestedBGL(tested);
        setTargetBGL(target);
        setExercise(exercise);
        setMeds(meds);
        setDiet(diet);
        setDate(date);
        setTime(time);

    }
    // Getters:

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setDate(String date){
        this.date = date;
    }
    public int getRegimen_ID() {
        return this.regimen_id;
    }

    public String getDoctor() {
        return this.doctor;
    }

    public String getTested() {
        return this.testedBGL;
    }

    public String getTarget() {
        return this.targetBGL;
    }

    public String getExercise() {
        return this.exercise;
    }

    public String getMeds() {
        return this.meds;
    }

    public String getDiet() {
        return this.diet;
    }

    // Setters:
    public void setRegimenId(int _id) {
        this.regimen_id = _id;
    }

    public void setDoctor(String _dr) {
        this.doctor = _dr;
    }

    public void setTestedBGL(String _tested) {
        this.testedBGL = _tested;
    }

    public void setTargetBGL(String _target) {
        this.targetBGL = _target;
    }

    public void setExercise(String _exer) {
        this.exercise = _exer;
    }

    public void setMeds(String _meds) {
        this.meds = _meds;
    }

    public void setDiet(String _diet) {
        this.diet = _diet;
    }
}

