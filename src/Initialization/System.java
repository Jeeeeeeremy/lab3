package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;
import view.admin.AdminView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class System {


    public static void main(String[] args) {
        //doctor set
        HashSet<Doctor> doctors = new HashSet<>();
        //<hospitalName, DoctorSet>
        HashMap<String,HashSet> hospital = new HashMap<>();
        //<communityName, hospitalName>
        HashMap<String,ArrayList<String>> communityDirectory = new HashMap<>();
        //<cityName,communityName>
        HashMap<String, ArrayList<String>> cityDirectory = new HashMap<>();
        //initialize all the three login UIs
//        AdminDir adminDir = new AdminDir();
//        AdminView adminView = new AdminView(adminDir);
//        adminView.setVisible(true);
        test t = new test();
        t.setVisible(true);
    }
}