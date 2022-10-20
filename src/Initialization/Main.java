package Initialization;

import model.Doctor;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    //doctor set
    HashSet<Doctor> doctors = new HashSet<>();
    //<hospitalName, DoctorSet>
    HashMap<String,HashSet> hospital = new HashMap<>();
    //<communityName, hospitalName>
    HashMap<String,String> communityDirectory = new HashMap<>();
    //<cityName,communityName>
    HashMap<String,String> cityDirectory = new HashMap<>();

    public static void main(String[] args) {
        //initialize all the three login UIs

    }
}