package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Login extends JFrame implements Page {
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton loginButton;
    private JPasswordField passwordField;

    String name;
    String password;

    Login() {
        setContentPane(panel1);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputName = nameTextField.getText();
                String inputPassword = String.valueOf(passwordField.getPassword());
                if (name.equalsIgnoreCase(inputName) && password.equals(inputPassword)) {
                    Pages.open(Login.this.nextPage());
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong user name or password");

                    Pages.close();
                }
            }
        });

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
    }

    abstract Page nextPage();

    public JFrame getjFrame() {
        return this;
    }

    @Override
    public boolean shouldSkip() {
        return true;
    }
}
