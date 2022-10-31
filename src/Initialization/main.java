package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;
import model.Patient;
import view.admin.MainView;

import java.util.ArrayList;
import java.util.HashMap;

public class main {


    public static void main(String[] args) {
        HashMap<String,ArrayList<Patient>> ComToPatients = new HashMap<>();
        ArrayList<Patient>  patients = new ArrayList<>();
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
        testdoctor.add(new Doctor("d1","h1"));
        testdoctor.add(new Doctor("d2","h1"));
        testdoctor.add(new Doctor("d3","h1"));
        ArrayList<Doctor> testdoctor2 = new ArrayList<>();
        testdoctor2.add(new Doctor("d1","h1"));
        testdoctor2.add(new Doctor("d2","h1"));
        testdoctor2.add(new Doctor("d3","h1"));
        ArrayList<Doctor> testdoctor3 = new ArrayList<>();
        testdoctor3.add(new Doctor("d1","h1"));
        testdoctor3.add(new Doctor("d2","h1"));
        testdoctor3.add(new Doctor("d3","h1"));
        hospitals.put("h1",testdoctor);
        hospitals.put("h2",testdoctor2);
        hospitals.put("h3",testdoctor3);
        //patients.add(new Patient("c1","c2","p1"));
        ArrayList<Patient> ps = new ArrayList<>();
        Patient pp = new Patient("c1","c2","p1");
        ps.add(pp);
        ComToPatients.put("test",ps);
        //initialize all the three login UIs
        AdminDir adminDir = new AdminDir();
        MainView mainView = new MainView(adminDir, patients,hospitals,communityDirectory,cityDirectory,ComToPatients);
        mainView.setVisible(true);

    }
}