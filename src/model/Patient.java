package model;

import javax.print.Doc;
import java.util.ArrayList;

public class Patient {
    String city;
    String community;
    String name;
    String account;
    String password;
    ArrayList<Encounter> encounterHistory;

    public Patient() {
    }

    public Patient(String city, String community, String name, ArrayList<Encounter> encounterHistory) {
        this.city = city;
        this.community = community;
        this.name = name;
        this.encounterHistory = encounterHistory;
    }

    public Patient(String city, String community, String name) {
        this.city = city;
        this.community = community;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Encounter> getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(ArrayList<Encounter> encounterHistory) {
        this.encounterHistory = encounterHistory;
    }

    public ArrayList<Hospital> searchHospital(){
        return null;
    }

    public ArrayList<Doctor> searchDoctor(){
        return null;
    }

    public void doctorAppointment(Doctor doctor){

    }


}
