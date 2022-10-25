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

/**
 * @author unknown
 */
public class displayInfo extends JFrame {
    ArrayList<Patient> patients;
    private String[] colunms;
    private String[][] data;
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
        String vital = "";
        for (Diagnosis diag :
                diagnosis) {
            vital += "<html><body><br>Blood Pressure: " + diag.getBloodPressure() +
                    "<br>Body Temperature: " + diag.getBodyTemperature() +
                    "<br>Body PulseRate: " + diag.getPulseRate() +
                    "<br>Body Rate Of Breathing: " + diag.getRateOfBreathing() +
                    "<br>Body Rate Of Breathing: " + diag.getDiagnosis() +
                    "<br><body></html>";
        }
        if (vital.length()==0){
            infoLabel.setText("NO DIAGNOSIS");
        }else {
            infoLabel.setText(vital);
        }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        view = new JButton();
        infoLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- view ----
        view.setText(bundle.getString("displayInfo.view.text"));
        view.addActionListener(e -> view(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(view)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(44, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1)
                        .addComponent(infoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(45, 45, 45)
                    .addComponent(view)
                    .addContainerGap(144, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
