/*
 * Created by JFormDesigner on Thu Oct 27 23:39:22 EDT 2022
 */

package view.admin;

import java.awt.event.*;
import java.util.*;
import controller.Admin.AdminImp;
import controller.Admin.CommunityAdminImp;
import model.Doctor;
import model.Patient;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author unknown
 */
public class ResAdminView extends JFrame {
    private String[] colunms;
    private String[][] data;
    AdminImp curAdmin;
    HashMap<String,ArrayList<String>> communityDirectory;
    HashMap<String,ArrayList<Patient>> ComToPatients;
    HashMap<String, ArrayList<Doctor>> hospitals;
    public ResAdminView(AdminImp curAdmin, HashMap<String,ArrayList<String>> communityDirectory, HashMap<String,ArrayList<Patient>>
            ComToPatients, HashMap<String, ArrayList<Doctor>> hospitals) {
        this.curAdmin = curAdmin;
        this.communityDirectory = communityDirectory;
        this.ComToPatients = ComToPatients;
        this.hospitals = hospitals;
        initComponents();
        for (String com :
                communityDirectory.keySet()) {
            comName.addItem(com);
        }
        comName.addItem("");
        comName.setSelectedItem("");
    }
    public ResAdminView() {

        initComponents();

    }

    private void check(ActionEvent e) {
        // TODO add your code here
        String coName = comName.getSelectedItem().toString();
        if (coName.equals("")){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one community");
            return;
        }
        new ComAdminFrame(new CommunityAdminImp(coName) ,communityDirectory.get(coName),ComToPatients.get(coName),hospitals).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        comName = new JComboBox();
        button1 = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText(bundle.getString("ResAdminView.button1.text"));
        button1.addActionListener(e -> check(e));

        //---- label1 ----
        label1.setText(bundle.getString("ResAdminView.label1.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(button1)
                    .addGap(68, 68, 68)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comName, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label1)
                        .addComponent(comName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(193, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JComboBox comName;
    private JButton button1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
