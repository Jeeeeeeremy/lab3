package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;
import model.Encounter;
import model.Patient;
import model.VitalSigns;
import view.admin.MainView;
import view.doctor.LoginFram;

import javax.print.Doc;
import java.util.*;

public class main {


    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> ComToPatients = new HashMap<>();
        ArrayList<String>  patients = new ArrayList<>();
        //<hospitalName, DoctorList>
        HashMap<String, ArrayList<Doctor>> hospitals = new HashMap<>();
        //<communityName, hospitalName>
        HashMap<String,ArrayList<String>> communityDirectory = new HashMap<>();
        //<cityName,communityName>
        HashMap<String, ArrayList<String>> cityDirectory = new HashMap<>();
        ArrayList<String> testHospital = new ArrayList<>();
        testHospital.add("h1");
        testHospital.add("h2");
        testHospital.add("h3");
        communityDirectory.put("test",testHospital);
        communityDirectory.put("test2",testHospital);
        ArrayList<Doctor> testdoctor = new ArrayList<>();
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        VitalSigns vitalSigns1 = new VitalSigns(36.5, 70, 170, 110);
        Encounter encounter1 = new Encounter(vitalSigns1, "");
        LinkedList<Encounter> encounterHistroy1 = new LinkedList<>();
        encounterHistroy1.add(encounter1);
        VitalSigns vitalSigns2 = new VitalSigns(36.3, 68, 90, 70);
        Encounter encounter2 = new Encounter(vitalSigns2, "");
        LinkedList<Encounter> encounterHistroy2 = new LinkedList<>();
        encounterHistroy1.add(encounter2);
        VitalSigns vitalSigns3 = new VitalSigns(38, 88, 120, 100);
        Encounter encounter3 = new Encounter(vitalSigns3, "");
        LinkedList<Encounter> encounterHistroy3 = new LinkedList<>();
        encounterHistroy1.add(encounter3);
        patientArrayList.add(new Patient("city1", "community1", "p1", encounterHistroy1, "p1", "p1"));
        patientArrayList.add(new Patient("city1", "community1", "p2", encounterHistroy2, "p2", "p2"));
        patientArrayList.add(new Patient("city2", "community2", "p3", encounterHistroy3, "p3", "p3"));
        testdoctor.add(new Doctor("d1","h1","d1","d1", patientArrayList));
        testdoctor.add(new Doctor("d2","h1","d2","d2", patientArrayList));
        testdoctor.add(new Doctor("d3","h1","d3","d3", patientArrayList));
        hospitals.put("h1",testdoctor);
        hospitals.put("h2",testdoctor);
        hospitals.put("h3",testdoctor);
        //initialize all the three login UIs
        AdminDir adminDir = new AdminDir();
        MainView mainView = new MainView(adminDir, patients,hospitals,communityDirectory,cityDirectory,ComToPatients);
        mainView.setVisible(true);

        LoginFram loginFram = new LoginFram(patients,hospitals,communityDirectory,cityDirectory,ComToPatients);
        loginFram.setVisible(true);
    }
}