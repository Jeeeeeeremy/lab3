package Initialization;

import model.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    //doctor set
    HashSet<Doctor> doctors = new HashSet<>();
    //<hospitalName, DoctorSet>
    HashMap<String,HashSet> hospital = new HashMap<>();
    //<communityName, hospitalName>
    HashMap<String,ArrayList<String>> communityDirectory = new HashMap<>();
    //<cityName,communityName>
    HashMap<String, ArrayList<String>> cityDirectory = new HashMap<>();

    public static void main(String[] args) {
        //initialize all the three login UIs

    }
}