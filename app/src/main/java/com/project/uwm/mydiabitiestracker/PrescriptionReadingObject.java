package com.project.uwm.mydiabitiestracker;

/**
 * Created by RWZ on 7/24/2017.
 */

public class PrescriptionReadingObject {
    private int prescription_id;
    private String drug_name;
    private int dosage;
    private String date;
    private String time;

    public PrescriptionReadingObject(int id, int dosage, String drug_type, String date, String time){
        setPrescriptionId(id);
        setDosage(dosage);
        setDrugName(drug_name);
        setDate(date);
        setTime(time);
    }

    public void setPrescriptionId(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getDrugName() {
        return drug_name;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public void setDrugName(String drug_type) {
        this.drug_name = drug_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
