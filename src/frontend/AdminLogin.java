package frontend;

import constant.LoginCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminLogin extends JFrame implements LoginCredentials, Node{
    private JPanel panel3;
    private JTextField NametextField;
    private JTextField passwordtextField;
    private JButton loginButton;
    private JPasswordField passwordField1;
    String name;
String password;
Node parent;
    AdminLogin(){
        setContentPane(panel3);
        setTitle("Admin login");
        setSize(450,300);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name=NametextField.getText();
                password= String.valueOf(passwordField1.getPassword());
                if (name.equals(LoginCredentials.ADMIN_USERNAME)&&password.equals(LoginCredentials.ADMIN_PASSWORD)) {
                    setVisible(false);
                    AdminRole adminRole=new AdminRole();}
                else

                    JOptionPane.showMessageDialog(null,"Wrong user name or password");

            }


        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            }
        });
    }

    @Override
    public void setParentNode(Node n) {
        this.parent=n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
