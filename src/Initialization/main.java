package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;
import view.admin.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class main {


    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> ComToPatients = new HashMap<>();
        ArrayList<String>  patients = new ArrayList<>();
        //<hospitalName, DoctorList>
        HashMap<String, List<String>> hospitals = new HashMap<>();
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
        ArrayList<String> testdoctor = new ArrayList<>();
        testdoctor.add("d1");
        testdoctor.add("d2");
        testdoctor.add("d3");
        hospitals.put("h1",testdoctor);
        hospitals.put("h2",testdoctor);
        hospitals.put("h3",testdoctor);
        //initialize all the three login UIs
        AdminDir adminDir = new AdminDir();
        MainView mainView = new MainView(adminDir, patients,hospitals,communityDirectory,cityDirectory,ComToPatients);
        mainView.setVisible(true);

    }
}