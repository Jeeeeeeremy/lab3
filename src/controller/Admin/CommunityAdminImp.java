package controller.Admin;

import model.Interface.Admin;

import java.util.ArrayList;
import java.util.HashSet;

public class CommunityAdminImp implements Admin {
    String curCom;
    String login;
    String password;

    public CommunityAdminImp() {
        curCom = null;
        login = "admin";
        password = "admin";
    }

    public CommunityAdminImp(String curCom, String login, String password) {
        this.curCom = curCom;
        this.login = login;
        this.password = password;
    }


    @Override
    public ArrayList<String> checkCommunityByCity(String city) {
        return null;
    }

    @Override
    public ArrayList<String> checkCommunityByCity() {
        return null;
    }

    @Override
    public ArrayList<String> checkHospitalByCommunity(String community) {
        return null;
    }

    @Override
    public ArrayList<String> checkHospitalByCommunity() {
        return null;
    }

    @Override
    public HashSet<String> checkDoctorByHospital(String hospital) {
        return null;
    }
}
