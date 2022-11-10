package frontend.auth;

import frontend.Node;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Login extends JFrame implements Node {
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton loginButton;
    private JPasswordField passwordField;
    String name;
    String password;
    private Node parent;

    Login() {
        setContentPane(panel1);
        setTitle("Librarian login");
        setSize(450, 300);
        setVisible(true);

        loginButton.addActionListener(e -> {
            String inputName = nameTextField.getText();
            String inputPassword = String.valueOf(passwordField.getPassword());
            if (name.equals(inputName) && password.equals(inputPassword)) {
                login();

               return;
            }

            JOptionPane.showMessageDialog(null, "Wrong user name or password");
        });

        passwordField.addActionListener((e) -> loginButton.doClick());

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            }
        });
    }

    abstract void login();

    @Override
    public void setParentNode(Node n) {

    }

    @Override
    public Node getParentNode() {
        return null;
    }
}
