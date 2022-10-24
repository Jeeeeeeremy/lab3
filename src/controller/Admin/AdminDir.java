package controller.Admin;

import java.util.HashMap;

public class AdminDir {
    //<userName,passWord>
    private HashMap<String,String> Admin = new HashMap<>();
    private HashMap<String,String> CommunityAdmin = new HashMap<>();


    public HashMap<String, String> getAdmin() {
        return Admin;
    }

    public HashMap<String, String> getCommunityAdmin() {
        return CommunityAdmin;
    }

    public void addAdmin(String login, String password) {
        Admin.put(login,password);
    }

    public void addCommunityAdmin(String login, String password) {
        CommunityAdmin.put(login,password);
    }
}
