package model;

import java.util.ArrayList;

public class Doctor {
    String Name;
    String Hospital;
    ArrayList<Diagnosis> Diagnose;

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


    public void setName(String name) {
        Name = name;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public ArrayList<Diagnosis> getDiagnose() {
        return Diagnose;
    }

    public void addDiagnose(Diagnosis diagnose) {
        Diagnose.add(diagnose);
    }
}
