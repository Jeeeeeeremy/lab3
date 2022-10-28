/*
 * Created by JFormDesigner on Mon Oct 24 17:21:48 EDT 2022
 */

package view.admin;

import java.awt.event.*;
import model.Diagnosis;
import model.Doctor;
import model.Patient;

import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author unknown
 */
public class displayInfo extends JFrame {
    ArrayList<Patient> patients;
    private String[] colunms;
    private String[][] data;
    Pattern digitp = Pattern.compile("^[-\\+]?[\\d]*$");
    public displayInfo(ArrayList<Patient> patients) {
        this.patients =patients ;
        initComponents();
        preparetable();
    }
    private void preparetable(){
        colunms = new String[]{"Community","patient name"};
        data = new String[patients.size()][colunms.length];
        int index = 0;
        for (Patient patient:
                patients) {
                    data[index][0] = patient.getCommunity();
                    data[index][1] = patient.getName();
                    index++;
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
    private void display(){


    }

    private void view(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row < 0) {
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        ArrayList<Diagnosis> diagnosis = patients.get(selected_row).getRecord();
        if (diagnosis.size()==0) {
            infoLabel.setText("NO DIAGNOSIS");
            return;
        }
        String vital = "<html><body>";
        int index = 1;
        for (Diagnosis diag :
                diagnosis) {
            vital += "diagnosis "+ index+"<br>Blood Pressure: " + diag.getBloodPressure() +
                    "<br>Body Temperature: " + diag.getBodyTemperature() +
                    "<br>Body PulseRate: " + diag.getPulseRate() +
                    "<br>Body Rate Of Breathing: " + diag.getRateOfBreathing() +
                    "<br>Body Diagnosis: " + diag.getDiagnosis() +
                    "<br><br>";
            index++;
        }

            infoLabel.setText(vital+"<body></html>");


    }

    private void modify(ActionEvent e) {
        int selected_row = table1.getSelectedRow();
        if (selected_row < 0) {
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to delete");
            return;
        }
        // TODO add your code here
        if (updateIndex.getText().equals("-1")){
            if (breath.getText().length()==0||
                !digitp.matcher(breath.getText()).matches()||
                pressure.getText().length()==0||
                !digitp.matcher(pressure.getText()).matches()||
                pulse.getText().length()==0||
                !digitp.matcher(pulse.getText()).matches()||
                temp.getText().length()==0||
                !digitp.matcher(temp.getText()).matches()||
                diagnose.getText().length()==0){
                JOptionPane.showMessageDialog(new JDialog(), ":please fill in all information correctly");
            }else {
                Diagnosis diagnosis = new Diagnosis(temp.getText(),pulse.getText(),breath.getText(),pressure.getText(),diagnose.getText());
                patients.get(selected_row).addRecord(diagnosis);
            }
        }else {
           Diagnosis diagnosis = patients.get(selected_row).getRecord().get(Integer.valueOf(updateIndex.getText())-1);
           if (pressure.getText().length()!=0)
               diagnosis.setBloodPressure(pressure.getText());
            if (breath.getText().length()!=0)
                diagnosis.setRateOfBreathing(breath.getText());
            if (pulse.getText().length()!=0)
                diagnosis.setPulseRate(pulse.getText());
            if (temp.getText().length()!=0)
                diagnosis.setBodyTemperature(temp.getText());
            if (diagnose.getText().length()!=0)
                diagnosis.setDiagnosis(diagnose.getText());
        }
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row < 0) {
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to delete");
            return;
        }
        if (deletIndex.getText().length()==0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one diagnose to delete");
            return;
        }
        if(deletIndex.getText().equals("-1")){
            patients.remove(selected_row);
            preparetable();
            return;
        }
        patients.get(selected_row).getRecord().remove(Integer.valueOf(deletIndex.getText())-1);
        preparetable();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        view = new JButton();
        infoLabel = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        pressure = new JTextField();
        deletIndex = new JTextField();
        updateIndex = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        temp = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        pulse = new JTextField();
        label6 = new JLabel();
        breath = new JTextField();
        label7 = new JLabel();
        diagnose = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- view ----
        view.setText(bundle.getString("displayInfo.view.text"));
        view.addActionListener(e -> view(e));

        //---- button1 ----
        button1.setText(bundle.getString("displayInfo.button1.text"));
        button1.addActionListener(e -> delete(e));

        //---- button2 ----
        button2.setText(bundle.getString("displayInfo.button2.text"));
        button2.addActionListener(e -> modify(e));

        //---- label1 ----
        label1.setText(bundle.getString("displayInfo.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("displayInfo.label2.text"));

        //---- label3 ----
        label3.setText(bundle.getString("displayInfo.label3.text"));

        //---- label4 ----
        label4.setText(bundle.getString("displayInfo.label4.text"));

        //---- label5 ----
        label5.setText(bundle.getString("displayInfo.label5.text"));

        //---- label6 ----
        label6.setText(bundle.getString("displayInfo.label6.text"));

        //---- label7 ----
        label7.setText(bundle.getString("displayInfo.label7.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(view)
                                    .addGap(77, 77, 77)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(button1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(deletIndex, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button2)
                                    .addGap(24, 24, 24)
                                    .addComponent(updateIndex, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label1))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                        .addComponent(temp, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pressure, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addComponent(label5)
                                            .addComponent(label6))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pulse, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(breath, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addGap(54, 54, 54)
                                    .addComponent(diagnose, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(116, 116, 116)
                    .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(infoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(view)
                                .addComponent(button1)
                                .addComponent(deletIndex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(22, 22, 22)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button2)
                                        .addComponent(label1)
                                        .addComponent(updateIndex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(pressure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(14, 14, 14)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(temp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pulse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label5))
                            .addGap(13, 13, 13)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(breath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addGap(48, 48, 48))
                                .addComponent(diagnose, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton view;
    private JLabel infoLabel;
    private JButton button1;
    private JButton button2;
    private JTextField pressure;
    private JTextField deletIndex;
    private JTextField updateIndex;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField temp;
    private JLabel label4;
    private JLabel label5;
    private JTextField pulse;
    private JLabel label6;
    private JTextField breath;
    private JLabel label7;
    private JTextField diagnose;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
