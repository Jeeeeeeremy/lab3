package Initialization;

import controller.Admin.AdminDir;
import model.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class main {


    public static void main(String[] args) {
        ArrayList<String>  patients = new ArrayList<>();
        //doctor set
        ArrayList<String> doctors = new ArrayList<>();
        //<hospitalName, DoctorSet>
        HashMap<String, List<String>> hospital = new HashMap<>();
        //<communityName, hospitalName>
        HashMap<String,ArrayList<String>> communityDirectory = new HashMap<>();
        //<cityName,communityName>
        HashMap<String, ArrayList<String>> cityDirectory = new HashMap<>();
        //initialize all the three login UIs
//        AdminDir adminDir = new AdminDir();
//        MainView mainView = new MainView(adminDir);
//        mainView.setVisible(true);

    }
}