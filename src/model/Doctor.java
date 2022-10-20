package model;

import java.util.ArrayList;

public class Doctor {
    String Name;
    String Hospital;
    ArrayList<String> Diagnose;

    public Doctor() {
    }

    public Doctor(String name, String hospital) {
        Name = name;
        Hospital = hospital;
    }

    public String getName() {
        return Name;
    }

    public String getHospital() {
        return Hospital;
    }

    public ArrayList<String> getDiagnose() {
        return Diagnose;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public void addDiagnose(String diagnose) {
        Diagnose.add(diagnose);
    }
}
