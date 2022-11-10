package frontend;

import constant.LoginCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LibrarianLogin extends JFrame implements Node{
    private JPanel panel2;
    private JTextField NametextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
String name;
String password;
    private Node parent;

    LibrarianLogin(){
        setContentPane(panel2);
        setTitle("Librarian login");
        setSize(450,300);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name=NametextField.getText();
                password= String.valueOf(passwordField1.getPassword());
                if (name.equals(LoginCredentials.LIBRARIAN_USERNAME) &&password.equals(LoginCredentials.LIBRARIAN_PASSWORD)){
                }
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
