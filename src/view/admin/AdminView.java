/*
 * Created by JFormDesigner on Sun Oct 23 21:41:14 EDT 2022
 */

package view.admin;

import java.awt.event.*;
import controller.Admin.AdminDir;

import java.awt.Component;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AdminView extends JPanel {
    AdminDir adminDir;
    public AdminView(AdminDir adminDir) {
        this.adminDir = adminDir;
        initComponents();
    }

    private boolean check(){
        if (password.getText().length()==0||
            login.getText().length()==0)
            return false;
        return true;
    }

    private boolean checkRegister(){
        return adminDir.getAdmin().containsKey(login.getText())||adminDir.getCommunityAdmin().containsKey(login.getText());
    }

    private boolean checkLogin(){
        return adminDir.getAdmin().containsKey(login.getText())||adminDir.getCommunityAdmin().containsKey(login.getText());
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        if (!check()){
            JOptionPane.showMessageDialog(new JDialog(), ":should enter login and password");
            return;
        }
        if (!checkLogin()){
            JOptionPane.showMessageDialog(new JDialog(), ":admin not existed");
            return;
        }
        if (!ComAdmin.isSelected()&&!ResAdmin.isSelected()){
            JOptionPane.showMessageDialog(new JDialog(), ":should select a role");
            return;
        }
        if (ComAdmin.isSelected()){
            if (adminDir.getCommunityAdmin().get(login.getText()).equals(password.getText())){
                //load community admin page
            }else {
                JOptionPane.showMessageDialog(new JDialog(), ":password wrong");
                return;
            }
        }else {
            if (adminDir.getAdmin().get(login.getText()).equals(password.getText())){
                //load resource admin page
            }else {
                JOptionPane.showMessageDialog(new JDialog(), ":password wrong");
                return;
            }
        }
    }

    private void register(ActionEvent e) {
        if (!check()){
            JOptionPane.showMessageDialog(new JDialog(), ":should enter login and password");
            return;
        }
        // TODO add your code here
        if (checkRegister()){
            JOptionPane.showMessageDialog(new JDialog(), ":admin existed");
            return;
        }
        if (!ComAdmin.isSelected()&&!ResAdmin.isSelected()){
            JOptionPane.showMessageDialog(new JDialog(), ":should select a role");
            return;
        }
        if (ComAdmin.isSelected()){
            adminDir.addCommunityAdmin(login.getText(),password.getText());
        }else {
            adminDir.addAdmin(login.getText(),password.getText());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        loginLable = new JLabel();
        paswordLabel = new JLabel();
        login = new JLabel();
        password = new JLabel();
        buttonLogin = new JButton();
        buttonRegister = new JButton();
        ComAdmin = new JRadioButton();
        ResAdmin = new JRadioButton();
        label1 = new JLabel();

        //======== this ========

        //---- loginLable ----
        loginLable.setText(bundle.getString("AdminView.loginLable.text"));

        //---- paswordLabel ----
        paswordLabel.setText(bundle.getString("AdminView.paswordLabel.text"));

        //---- buttonLogin ----
        buttonLogin.setText(bundle.getString("AdminView.buttonLogin.text"));
        buttonLogin.addActionListener(e -> login(e));

        //---- buttonRegister ----
        buttonRegister.setText(bundle.getString("AdminView.buttonRegister.text"));
        buttonRegister.addActionListener(e -> register(e));

        //---- ComAdmin ----
        ComAdmin.setText(bundle.getString("AdminView.ComAdmin.text"));

        //---- ResAdmin ----
        ResAdmin.setText(bundle.getString("AdminView.ResAdmin.text"));

        //---- label1 ----
        label1.setText(bundle.getString("AdminView.label1.text"));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(253, 253, 253)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(ResAdmin)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonLogin)
                                .addGap(108, 108, 108)
                                .addComponent(buttonRegister))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(paswordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(loginLable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(login, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(password, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                .addGap(106, 106, 106)
                                .addComponent(ComAdmin))))
                    .addContainerGap(173, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(534, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(300, 300, 300))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {loginLable, paswordLabel});
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {login, password});
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {ComAdmin, ResAdmin});
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(loginLable, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(login, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addComponent(label1)
                            .addGap(30, 30, 30)
                            .addComponent(ComAdmin)))
                    .addGap(34, 34, 34)
                    .addComponent(ResAdmin)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(paswordLabel)
                        .addComponent(password))
                    .addGap(61, 61, 61)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRegister)
                        .addComponent(buttonLogin))
                    .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.linkSize(SwingConstants.VERTICAL, new Component[] {loginLable, paswordLabel});
        layout.linkSize(SwingConstants.VERTICAL, new Component[] {login, password});
        layout.linkSize(SwingConstants.VERTICAL, new Component[] {ComAdmin, ResAdmin});

        //---- roleSelection ----
        var roleSelection = new ButtonGroup();
        roleSelection.add(ComAdmin);
        roleSelection.add(ResAdmin);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel loginLable;
    private JLabel paswordLabel;
    private JLabel login;
    private JLabel password;
    private JButton buttonLogin;
    private JButton buttonRegister;
    private JRadioButton ComAdmin;
    private JRadioButton ResAdmin;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
