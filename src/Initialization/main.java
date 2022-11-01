package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;
import model.Encounter;
import model.Patient;
import model.VitalSigns;
import view.admin.MainView;
import view.doctor.DoctorLoginFram;
import view.patient.PatientLoginFram;

import java.util.*;

public class main {


    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> ComToPatients = new HashMap<>();
        ArrayList<Patient>  patients = new ArrayList<>();
        //<hospitalName, DoctorList>
        HashMap<String, ArrayList<Doctor>> hospitals = new HashMap<>();
        //<communityName, hospitalName>
        HashMap<String,ArrayList<String>> communityDirectory = new HashMap<>();
        //<cityName,communityName>
        HashMap<String, ArrayList<String>> cityDirectory = new HashMap<>();
        ArrayList<String> testHospital1 = new ArrayList<>();
        testHospital1.add("h1");
        testHospital1.add("h2");
        testHospital1.add("h3");
        ArrayList<String> testHospital2 = new ArrayList<>();
        testHospital1.add("h4");
        testHospital1.add("h5");
        testHospital1.add("h6");
        communityDirectory.put("community1",testHospital1);
        communityDirectory.put("community2",testHospital2);
        ArrayList<Doctor> testdoctor1 = new ArrayList<>();
        ArrayList<Doctor> testdoctor2 = new ArrayList<>();
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        VitalSigns vitalSigns1 = new VitalSigns(36.5, 70, 170, 110);
        Encounter encounter1 = new Encounter(vitalSigns1, "");
        LinkedList<Encounter> encounterHistroy1 = new LinkedList<>();
        encounterHistroy1.add(encounter1);
        VitalSigns vitalSigns2 = new VitalSigns(36.3, 68, 90, 70);
        Encounter encounter2 = new Encounter(vitalSigns2, "");
        LinkedList<Encounter> encounterHistroy2 = new LinkedList<>();
        encounterHistroy2.add(encounter2);
        VitalSigns vitalSigns3 = new VitalSigns(38, 88, 120, 100);
        Encounter encounter3 = new Encounter(vitalSigns3, "");
        LinkedList<Encounter> encounterHistroy3 = new LinkedList<>();
        encounterHistroy3.add(encounter3);
        Patient patient1 = new Patient("city1", "community1", "p1", encounterHistroy1, "p1", "p1");
        Patient patient2 = new Patient("city1", "community1", "p2", encounterHistroy2, "p2", "p2");
        Patient patient3 = new Patient("city2", "community2", "p3", encounterHistroy3, "p3", "p3");
        patientArrayList.add(patient1);
        patientArrayList.add(patient2);
        patientArrayList.add(patient3);
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        testdoctor1.add(new Doctor("d1","h1","d1","d1", patientArrayList));
        testdoctor1.add(new Doctor("d2","h1","d2","d2", patientArrayList));
        testdoctor1.add(new Doctor("d3","h1","d3","d3", patientArrayList));

        ArrayList<Patient> patientArrayList2 = new ArrayList<>();
        VitalSigns vitalSigns4 = new VitalSigns(36.5, 70, 170, 110);
        Encounter encounter4 = new Encounter(vitalSigns4, "");
        LinkedList<Encounter> encounterHistroy4 = new LinkedList<>();
        encounterHistroy4.add(encounter4);
        VitalSigns vitalSigns5 = new VitalSigns(36.3, 68, 90, 70);
        Encounter encounter5 = new Encounter(vitalSigns5, "");
        LinkedList<Encounter> encounterHistroy5 = new LinkedList<>();
        encounterHistroy5.add(encounter5);
        VitalSigns vitalSigns6 = new VitalSigns(38, 88, 120, 100);
        Encounter encounter6 = new Encounter(vitalSigns6, "");
        LinkedList<Encounter> encounterHistroy6 = new LinkedList<>();
        encounterHistroy6.add(encounter6);
        Patient patient4 = new Patient("city1", "community1", "p4", encounterHistroy1, "p4", "p4");
        Patient patient5 = new Patient("city1", "community1", "p5", encounterHistroy2, "p5", "p5");
        Patient patient6 = new Patient("city2", "community2", "p6", encounterHistroy3, "p6", "p6");
        patientArrayList.add(patient4);
        patientArrayList.add(patient5);
        patientArrayList.add(patient6);
        patients.add(patient4);
        patients.add(patient5);
        patients.add(patient6);
        testdoctor2.add(new Doctor("d4","h4","d4","d4", patientArrayList));
        testdoctor2.add(new Doctor("d5","h5","d5","d5", patientArrayList));
        testdoctor2.add(new Doctor("d6","h6","d6","d6", patientArrayList));

        hospitals.put("h1",testdoctor1);
        hospitals.put("h2",testdoctor2);
        //initialize all the three login UIs
        AdminDir adminDir = new AdminDir();
        MainView mainView = new MainView(adminDir, patients, hospitals, communityDirectory, cityDirectory, ComToPatients);
        mainView.setVisible(true);

        DoctorLoginFram doctorLoginFram = new DoctorLoginFram(patients, hospitals, communityDirectory, cityDirectory, ComToPatients);
        doctorLoginFram.setVisible(true);

        PatientLoginFram patientLoginFram = new PatientLoginFram(patients, hospitals, communityDirectory, cityDirectory, ComToPatients);
        patientLoginFram.setVisible(true);
    }
}