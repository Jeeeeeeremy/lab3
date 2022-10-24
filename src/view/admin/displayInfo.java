/*
 * Created by JFormDesigner on Mon Oct 24 17:21:48 EDT 2022
 */

package view.admin;

import model.Diagnosis;
import model.Patient;

import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class displayInfo extends JFrame {
    ArrayList<Patient> patients;
    public displayInfo(ArrayList<Patient> patients) {
        this.patients =patients ;
        initComponents();
        display();
    }

    private void display(){
        String toAdd = "";
        for (Patient patient :
                patients) {
            String basicInfo = "<html><body> " +
                    "<br>Name: "+ patient.getName()+
                    "<br>Community: "+ patient.getCommunity();
            String vital = "";
            for (Diagnosis diag :
                    patient.getRecord()) {
                vital+= "<br>Blood Pressure: "+ diag.getBloodPressure()+
                        "<br>Body Temperature: "+ diag.getBodyTemperature()+
                        "<br>Body PulseRate: "+ diag.getPulseRate()+
                        "<br>Body Rate Of Breathing: "+ diag.getRateOfBreathing()+
                        "<br>Body Rate Of Breathing: "+ diag.getDiagnosis()+
                        "<br><body></html>";
            }
            toAdd += basicInfo+vital;
        }
        info_label.setText(toAdd);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        info_label = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(info_label, GroupLayout.PREFERRED_SIZE, 785, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(info_label, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel info_label;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
