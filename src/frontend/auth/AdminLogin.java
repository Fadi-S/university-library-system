package frontend.auth;

import constant.LoginCredentials;
import frontend.AdminRole;
import frontend.Node;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminLogin extends Login implements Node {
    Node parent;

    public AdminLogin() {
        setTitle("Admin login");

        name = LoginCredentials.ADMIN_USERNAME;
        password = LoginCredentials.ADMIN_PASSWORD;

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            }
        });
    }

    @Override
    void login() {
        new AdminRole();
    }

    @Override
    public void setParentNode(Node n) {
        this.parent = n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
