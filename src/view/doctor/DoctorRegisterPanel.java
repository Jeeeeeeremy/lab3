package view.doctor;

import model.Doctor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gulinigeer
 */
public class DoctorRegisterPanel extends javax.swing.JPanel {
    private HashMap<String, ArrayList<Doctor>> hospitals;
    private HashMap<String,ArrayList<String>> communityDirectory;
    private HashMap<String, ArrayList<String>> cityDirectory;
    private LoginFram loginFram;
    /**
     * Creates new form DoctorRegisterPanel
     */
    public DoctorRegisterPanel() {
        initComponents();
    }

    public DoctorRegisterPanel(HashMap<String, ArrayList<Doctor>> hospitals, HashMap<String,ArrayList<String>> communityDirectory, HashMap<String, ArrayList<String>> cityDirectory){
        this.hospitals = hospitals;
        this.communityDirectory = communityDirectory;
        this.cityDirectory = cityDirectory;
        initComponents();
    }

    public DoctorRegisterPanel(HashMap<String, ArrayList<Doctor>> hospitals, HashMap<String,ArrayList<String>> communityDirectory, HashMap<String, ArrayList<String>> cityDirectory, LoginFram loginFram){
        this.hospitals = hospitals;
        this.communityDirectory = communityDirectory;
        this.cityDirectory = cityDirectory;
        this.loginFram = loginFram;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        registerButton = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        community = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hospital = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Account");

        jLabel3.setText("Community");

        jLabel4.setText("Password");

        jLabel1.setText("Name");

        jLabel5.setText("Hospital");

        jLabel6.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(registerButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                        .addComponent(community)
                                        .addComponent(hospital)
                                        .addComponent(account)
                                        .addComponent(name)
                                        .addComponent(city))
                                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(community, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addComponent(registerButton)
                                .addGap(55, 55, 55))
        );
    }// </editor-fold>

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String nameText = name.getText();
        String accountText = account.getText();
        String passwordText = password.getText();
        String hospitalText = hospital.getText();
        String cityText = city.getText();
        String communityText = community.getText();
        if(cityText.isEmpty() || communityText.isEmpty() || hospitalText.isEmpty() || nameText.isEmpty() || accountText.isEmpty() || passwordText.isEmpty()){
            JOptionPane.showMessageDialog(this,"The input cannot be empty!!!");
            return;
        }
        //city exist
        if(cityDirectory.keySet().contains(cityText)){
            //community exist
            if(cityDirectory.get(cityText).contains(communityText)){
                //hospital exsit
                if(communityDirectory.get(communityText).contains(hospitalText)){
                    //add doctor
                    hospitals.get(hospitalText).add(new Doctor(nameText, hospitalText, accountText, passwordText));
                }else {
                    communityDirectory.get(communityText).add(hospitalText);
                    ArrayList<Doctor> doctors = new ArrayList<>();
                    doctors.add(new Doctor(nameText, hospitalText, accountText, passwordText));
                    this.hospitals.put(hospitalText,doctors);
                }
            }else {
                cityDirectory.get(cityText).add(communityText);
                ArrayList<String> hospitals = new ArrayList<>();
                hospitals.add(hospitalText);
                communityDirectory.put(communityText,hospitals);
                ArrayList<Doctor> doctors = new ArrayList<>();
                doctors.add(new Doctor(nameText, hospitalText, accountText, passwordText));
                this.hospitals.put(hospitalText,doctors);
            }
        }else {
            ArrayList<String> community = new ArrayList<>();
            community.add(communityText);
            cityDirectory.put(cityText,community);
            ArrayList<String> hospitals = new ArrayList<>();
            hospitals.add(hospitalText);
            communityDirectory.put(communityText,hospitals);
            ArrayList<Doctor> doctors = new ArrayList<>();
            doctors.add(new Doctor(nameText, hospitalText, accountText, passwordText));
            this.hospitals.put(hospitalText,doctors);
        }
        loginFram.getjSplitPane1().setRightComponent(new DoctorPanel(hospitals, communityDirectory, cityDirectory, new Doctor(nameText, hospitalText, accountText, passwordText)));
    }

    private Boolean isEmpty(String s){
        if(null != s && !"".equals(s)){
            return false;
        }else {
            return true;
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField account;
    private javax.swing.JTextField community;
    private javax.swing.JTextField hospital;
    private javax.swing.JTextField city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JButton registerButton;
    // End of variables declaration
}

