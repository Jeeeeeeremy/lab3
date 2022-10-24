package model;

import java.util.ArrayList;

public class Patient {
    String city;
    String community;
    String name;
    ArrayList<Diagnosis> record = new ArrayList<>();

    public Patient() {
    }

    public Patient(String city, String community, String name, ArrayList<Diagnosis> record) {
        this.city = city;
        this.community = community;
        this.name = name;
        this.record = record;
    }

    public Patient(String city, String community, String name) {
        this.city = city;
        this.community = community;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getCommunity() {
        return community;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Diagnosis> getRecord() {
        return record;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRecord(Diagnosis record) {
        this.record.add(record);
    }
}
