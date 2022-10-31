/*
 * Created by JFormDesigner on Mon Oct 24 17:21:48 EDT 2022
 */

package view.admin;

import model.Patient;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1013, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(4, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
