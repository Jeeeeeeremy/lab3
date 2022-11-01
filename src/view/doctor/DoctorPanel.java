package view.doctor;

import model.Doctor;
import model.Encounter;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gulinigeer
 */
public class DoctorPanel extends javax.swing.JPanel {

    private Doctor doctor;
    private HashMap<String, ArrayList<Doctor>> hospitals;
    private HashMap<String,ArrayList<String>> communityDirectory;
    private HashMap<String, ArrayList<String>> cityDirectory;
    /**
     * Creates new form PatientPanel
     */
    public DoctorPanel() {
        initComponents();
        displayTable(doctor.getPatientWaitingList());
    }

    public DoctorPanel(HashMap<String, ArrayList<Doctor>> hospitals, HashMap<String,ArrayList<String>> communityDirectory, HashMap<String, ArrayList<String>> cityDirectory, Doctor doctor){
        this.hospitals = hospitals;
        this.communityDirectory = communityDirectory;
        this.cityDirectory = cityDirectory;
        this.doctor = doctor;
        initComponents();
        displayTable(doctor.getPatientWaitingList());
    }

    void displayTable(ArrayList<Patient> patientList){
        if(null == patientList || patientList.size() == 0){
            return;
        }
        DefaultTableModel model = (DefaultTableModel)patientTable.getModel();
        model.setRowCount(0);
        patientTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        for(Patient patient : patientList){
            String[] row = new String[3];
            row[0] = patient.getName();
            row[1] = patient.getCity();
            row[2] = patient.getCommunity();
            model.addRow(row);
        }
    }

    private void rowClick(){
        int selectedRow = patientTable.getSelectedRow();
        if(selectedRow >= 0){
            displayPatient(doctor.getPatientWaitingList().get(selectedRow));
        }
    }

    void displayPatient(Patient patient){
        Encounter last = patient.getEncounterHistory().getLast();
        bodyTemperature.setText(last.getVitalSigns().getBodyTemperature()+"");
        pulseRate.setText(last.getVitalSigns().getPulseRate()+"");
        diastolicPressure.setText(last.getVitalSigns().getDiastolicPressure()+"");
        systolicPressure.setText(last.getVitalSigns().getSystolicPressure()+"");
        diagnose.setText(last.getDiagnose());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        patientItem = new javax.swing.JComboBox<>();
        searchText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        diagnoseButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bodyTemperature = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pulseRate = new javax.swing.JTextField();
        diastolicPressure = new javax.swing.JTextField();
        systolicPressure = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        diagnose = new javax.swing.JTextField();

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Patient Name", "City", "Community"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientTable);

        patientItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "City", "Community" }));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        diagnoseButton.setText("Diagnose");
        diagnoseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnoseButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("bodyTemperature");

        jLabel2.setText("pulseRate");

        jLabel3.setText("diastolicPressure");

        jLabel4.setText("systolicPressure");

        jLabel5.setText("diagnose");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bodyTemperature)
                                                        .addComponent(pulseRate)
                                                        .addComponent(diastolicPressure)
                                                        .addComponent(systolicPressure)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(patientItem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(searchButton)
                                        .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                                .addComponent(diagnoseButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(diagnose)))
                                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton)
                                        .addComponent(diagnoseButton))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(bodyTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(diagnose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pulseRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(diastolicPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(systolicPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void diagnoseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = patientTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this,"please select a patient to diagnose!");
            return;
        }
        String diagnoseText = diagnose.getText();
        Encounter last = doctor.getPatientWaitingList().get(selectedRow).getEncounterHistory().getLast();
        last.setDiagnose(diagnoseText);
        JOptionPane.showMessageDialog(this,"Successful Diagnosis!");
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String text = searchText.getText();
        String patientItem = this.patientItem.getSelectedItem().toString();
        ArrayList<Patient> result = new ArrayList<>();
        switch (patientItem){
            case "Name":
                for(Patient patient : doctor.getPatientWaitingList()){
                    if(patient.getName().contains(text)){
                        result.add(patient);
                    }
                }
                if(result.size() == 0){
                    JOptionPane.showMessageDialog(this,"Can Not Find Such Patient!");
                }else {
                    displayTable(result);
                }
                break;
            case "City":
                for(Patient patient : doctor.getPatientWaitingList()){
                    if(patient.getCity().contains(text)){
                        result.add(patient);
                    }
                }
                if(result.size() == 0){
                    JOptionPane.showMessageDialog(this,"Can Not Find Such Patient!");
                }else {
                    displayTable(result);
                }
                break;
            case "Community":
                for(Patient patient : doctor.getPatientWaitingList()){
                    if(patient.getCommunity().contains(text)){
                        result.add(patient);
                    }
                }
                if(result.size() == 0){
                    JOptionPane.showMessageDialog(this,"Can Not Find Such Patient!");
                }else {
                    displayTable(result);
                }
                break;
            default:
                break;
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JTextField bodyTemperature;
    private javax.swing.JTextField diagnose;
    private javax.swing.JButton diagnoseButton;
    private javax.swing.JTextField diastolicPressure;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> patientItem;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField pulseRate;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField systolicPressure;
    // End of variables declaration
}
