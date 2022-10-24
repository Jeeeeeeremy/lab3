/*
 * Created by JFormDesigner on Mon Oct 24 13:10:28 EDT 2022
 */

package view.admin;

import java.awt.event.*;
import java.util.*;
import controller.Admin.CommunityAdminImp;

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
    ArrayList<String> patients;
    HashMap<String, List<String>> doctors;
    public ComAdminFrame(CommunityAdminImp curAdmin, ArrayList<String> hospitals, ArrayList<String> patients, HashMap<String, List<String>> doctors) {
        this.curAdmin = curAdmin;
        this.hospitals = hospitals;
        this.patients = patients;
        this.doctors = doctors;
        preparetable();
        initComponents();
    }

    public ComAdminFrame() {
        initComponents();
    }

    private void preparetable(){
        colunms = new String[]{"Community","Hospital","doctor name"};
        data = new String[hospitals.size()*doctors.size()][colunms.length];
        int index = 0;
        for (String hospital:
                hospitals) {
            if (doctors.containsKey(hospital)){
                for (String doctor:
                        doctors.get(hospital)) {
                    data[index][0] = curAdmin.getCurCom();
                    data[index][1] = hospital;
                    data[index][2] = doctor;
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
    }

    private void seachDoctorList(ActionEvent e) {
        // TODO add your code here
//        colunms = new String[]{"hospital","Name"};
//        int selected_row = table1.getSelectedRow();
//        TableModel tempmodel = table1.getModel();
//        String hospitalName =(String)tempmodel.getValueAt(selected_row,1);
//        data = new String[doctors.get(hospitalName).size()][colunms.length];
//        int index = 0;
//        for (String doctor:
//                doctors.get(hospitalName)) {
//            data[index][0] = hospitalName;
//            data[index][1] = doctor;
//            index++;
//        }
//        DefaultTableModel model = new DefaultTableModel(data,colunms);
//        table1 = new JTable(model){
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        //table1 = new JTable();
        seachDoctorList = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- seachDoctorList ----
        seachDoctorList.setText(bundle.getString("ComAdminFrame.seachDoctorList.text"));
        seachDoctorList.addActionListener(e -> seachDoctorList(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(207, 207, 207)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(468, 468, 468)
                            .addComponent(seachDoctorList)))
                    .addContainerGap(232, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(seachDoctorList)
                    .addContainerGap(181, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton seachDoctorList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
