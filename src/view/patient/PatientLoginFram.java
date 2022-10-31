package view.patient;

import model.Doctor;
import model.Patient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author qiaotong
 */
public class PatientLoginFram  extends javax.swing.JFrame {
    private List<Patient> patients;
    private HashMap<String, ArrayList<Doctor>> hospitals;
    private HashMap<String,ArrayList<String>> communityDirectory;
    private HashMap<String, ArrayList<String>> cityDirectory;
    private HashMap<String,ArrayList<String>> ComToPatients;
    /**
     * Creates new form LoginJFram
     */
    public PatientLoginFram() {
        initComponents();
    }

    public PatientLoginFram(List<Patient> patients, HashMap<String, ArrayList<Doctor>> hospitals, HashMap<String,ArrayList<String>> communityDirectory, HashMap<String, ArrayList<String>> cityDirectory, HashMap<String,ArrayList<String>> ComToPatients) {
        this.patients = patients;
        this.hospitals = hospitals;
        this.communityDirectory = communityDirectory;
        this.cityDirectory = cityDirectory;
        this.ComToPatients = ComToPatients;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        accountText = new javax.swing.JTextField();
        passwordText = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        userTypeItem = new javax.swing.JComboBox<>();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 443, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabel1.setText("Account");

        jLabel2.setText("Password");

        jLabel3.setText("User Type");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        userTypeItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Patient"}));

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginButton)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(registerButton)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(passwordText, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(accountText, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(userTypeItem, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(accountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(userTypeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(registerButton))
                                .addContainerGap(94, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSplitPane1)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String accountTextText = accountText.getText();
        String passwordTextText = passwordText.getText();
        if(accountTextText.isEmpty() || passwordTextText.isEmpty()){
            JOptionPane.showMessageDialog(this,"The input cannot be empty!!!");
            return;
        }
        AtomicInteger login = new AtomicInteger(-1);
        for (Patient patient : patients){
            if(accountTextText.equals(patient.getAccount()) && passwordTextText.equals(patient.getPassword())){
                this.jSplitPane1.setRightComponent(new PatientPanel(patient, hospitals, communityDirectory, cityDirectory));
                login.set(1);
            }
        }
        if(login.get() == -1){
            JOptionPane.showMessageDialog(this,"User does not exist!!!");
        }
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new PatientRegisterPanel(patients, ComToPatients, cityDirectory, hospitals, communityDirectory, this));

    }


    // Variables declaration - do not modify
    private javax.swing.JTextField accountText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordText;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox<String> userTypeItem;
    // End of variables declaration
    public JSplitPane getjSplitPane1() {
        return jSplitPane1;
    }

    public void setjSplitPane1(JSplitPane jSplitPane1) {
        this.jSplitPane1 = jSplitPane1;
    }

}
