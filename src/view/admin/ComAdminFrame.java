/*
 * Created by JFormDesigner on Mon Oct 24 13:10:28 EDT 2022
 */

package view.admin;

import java.awt.event.*;
import java.util.*;
import controller.Admin.CommunityAdminImp;
import model.Doctor;
import model.Patient;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author unknown
 */
public class ComAdminFrame extends JFrame {


    private String[] colunms;
    private String[][] data;
    CommunityAdminImp curAdmin;
    ArrayList<String> hospitals;
    ArrayList<Patient> patients;
    HashMap<String, ArrayList<Doctor>> doctors;
    public ComAdminFrame(CommunityAdminImp curAdmin, ArrayList<String> hospitals, ArrayList<Patient> patients, HashMap<String, ArrayList<Doctor>> doctors) {
        this.curAdmin = curAdmin;
        this.hospitals = hospitals;
        this.patients = patients;
        this.doctors = doctors;
        initComponents();
        preparetable();
    }

    public ComAdminFrame() {
        initComponents();
    }

    private void preparetable(){
        colunms = new String[]{"Community","Hospital","doctor name"};
        int size = 0;
        for (String key:
            doctors.keySet()){
            size+=doctors.get(key).size();
        }
        data = new String[size][colunms.length];
        int index = 0;
        for (String hospital:
                hospitals) {
            if (doctors.containsKey(hospital)&&doctors.get(hospital).size()>0){
                for (Doctor doctor:
                        doctors.get(hospital)) {
                    data[index][0] = curAdmin.getCurCom();
                    data[index][1] = hospital;
                    data[index][2] = doctor.getName();
                    index++;
                }
            }
        }
        DefaultTableModel model = new DefaultTableModel(data,colunms);
        table1 = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane1.setViewportView(table1);
    }

    private void seachDoctorList(ActionEvent e) {
        // TODO add your code here

    }

    private void delete(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String hospitalName =(String)tempmodel.getValueAt(selected_row,1);
        String doctorName =(String)tempmodel.getValueAt(selected_row,2);
        for (Doctor d :
                doctors.get(hospitalName)) {
            if (d.getName().equals(doctorName)) {
                doctors.get(hospitalName).remove(d);
                if (doctors.get(hospitalName).size()==0){
                    hospitals.remove(hospitalName);
                    doctors.remove(hospitalName);
                }
                preparetable();
                return;
            }
        }
    }

    private void ViewPatient(ActionEvent e) {
        // TODO add your code here
        new displayInfo(patients).setVisible(true);
    }

    private void viewDiagnosis(ActionEvent e) {
        // TODO add your code here
    }

    private void addDoctor(ActionEvent e) {
        // TODO add your code here
        if (doctorName.getText().length()==0){
            JOptionPane.showMessageDialog(new JDialog(), ":please enter the name");
            return;
        }
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String hName = (String)tempmodel.getValueAt(selected_row,1);
        doctors.get(hName).add(new Doctor(doctorName.getText(),hName));
        doctorName.setText("");
        preparetable();
    }

    private void addPatient(ActionEvent e) {
        // TODO add your code here
        if (patientName.getText().length()==0){
            JOptionPane.showMessageDialog(new JDialog(), ":please enter the name");
            return;
        }
        patients.add(new Patient("Toronto",curAdmin.getCurCom(),patientName.getText()));
        patientName.setText("");
    }

    private void updateDoctor(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String hName = (String)tempmodel.getValueAt(selected_row,1);
        String dName = (String)tempmodel.getValueAt(selected_row,2);
        for (Doctor d :
                doctors.get(hName)) {
            if (d.getName().equals(dName)){
                String newName = doctorUpdateName.getText().length()==0 ? dName:doctorUpdateName.getText();
                String newHospital = doctorUpdateHospital.getText().length()==0 ? hName:doctorUpdateHospital.getText();
                if (!doctors.containsKey(newHospital)){
                    JOptionPane.showMessageDialog(new JDialog(), ":hospital not existed");
                    return;
                }
                d.setName(newName);
                d.setHospital(newHospital);
                doctors.get(hName).remove(d);
                doctors.get(newHospital).add(d);
                if (doctors.get(hName).size()==0){
                    hospitals.remove(hName);
                    doctors.remove(hName);
                }

                preparetable();
                return;
            }
        }
    }

    private void deleteHospital(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String hName = (String)tempmodel.getValueAt(selected_row,1);
        doctors.remove(hName);
        hospitals.remove(hName);
        preparetable();
    }

    private void addHospital(ActionEvent e) {
        // TODO add your code here
        if (newHospital.getText().length()==0||
            firstDoctor.getText().length()==0){
            JOptionPane.showMessageDialog(new JDialog(), ":please enter the doctor name and hospital name");
            return;
        }
        if (hospitals.contains(newHospital.getText())){
            JOptionPane.showMessageDialog(new JDialog(), ":hospital existed");
            return;
        }
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(firstDoctor.getText(),newHospital.getText()));
        doctors.put(newHospital.getText(),list);
        hospitals.add(newHospital.getText());
        preparetable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        doctorName = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        patientName = new JTextField();
        label3 = new JLabel();
        doctorUpdateName = new JTextField();
        label4 = new JLabel();
        doctorUpdateHospital = new JTextField();
        button7 = new JButton();
        label5 = new JLabel();
        firstDoctor = new JTextField();
        label6 = new JLabel();
        newHospital = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText(bundle.getString("ComAdminFrame.button1.text"));
        button1.addActionListener(e -> updateDoctor(e));

        //---- button2 ----
        button2.setText(bundle.getString("ComAdminFrame.button2.text"));
        button2.addActionListener(e -> delete(e));

        //---- button3 ----
        button3.setText(bundle.getString("ComAdminFrame.button3.text"));
        button3.addActionListener(e -> addDoctor(e));

        //---- button4 ----
        button4.setText(bundle.getString("ComAdminFrame.button4.text"));
        button4.addActionListener(e -> ViewPatient(e));

        //---- button5 ----
        button5.setText(bundle.getString("ComAdminFrame.button5.text"));
        button5.addActionListener(e -> deleteHospital(e));

        //---- button6 ----
        button6.setText(bundle.getString("ComAdminFrame.button6.text"));
        button6.addActionListener(e -> addPatient(e));

        //---- label1 ----
        label1.setText(bundle.getString("ComAdminFrame.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("ComAdminFrame.label2.text"));

        //---- label3 ----
        label3.setText(bundle.getString("ComAdminFrame.label3.text"));

        //---- label4 ----
        label4.setText(bundle.getString("ComAdminFrame.label4.text"));

        //---- button7 ----
        button7.setText(bundle.getString("ComAdminFrame.button7.text"));
        button7.addActionListener(e -> addHospital(e));

        //---- label5 ----
        label5.setText(bundle.getString("ComAdminFrame.label5.text"));

        //---- label6 ----
        label6.setText(bundle.getString("ComAdminFrame.label6.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button6)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(patientName, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                            .addGap(36, 36, 36)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button4)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(doctorName, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(69, 69, 69)
                                            .addComponent(label3)
                                            .addGap(6, 6, 6)
                                            .addComponent(doctorUpdateName, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addGap(63, 63, 63)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                    .addComponent(label4)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(doctorUpdateHospital, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
                                    .addGap(98, 98, 98)
                                    .addComponent(button5)
                                    .addGap(31, 31, 31)
                                    .addComponent(button2))))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newHospital, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                            .addComponent(button7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(20, 20, 20)
                            .addComponent(firstDoctor, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(102, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {button2, button5, button6});
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label3, label4});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(button4)
                    .addGap(33, 33, 33)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(patientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(doctorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button6)
                                .addComponent(button3)
                                .addComponent(button1)
                                .addComponent(button5)
                                .addComponent(button2))
                            .addGap(3, 3, 3)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(label3))
                                .addComponent(doctorUpdateName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(doctorUpdateHospital, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))))
                    .addGap(60, 60, 60)
                    .addComponent(button7)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(newHospital, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(firstDoctor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(164, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextField doctorName;
    private JLabel label1;
    private JLabel label2;
    private JTextField patientName;
    private JLabel label3;
    private JTextField doctorUpdateName;
    private JLabel label4;
    private JTextField doctorUpdateHospital;
    private JButton button7;
    private JLabel label5;
    private JTextField firstDoctor;
    private JLabel label6;
    private JTextField newHospital;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
