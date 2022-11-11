package frontend.auth;

import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

public abstract class Login extends JFrame implements Page {
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton loginButton;
    private JPasswordField passwordField;
    String name;
    String password;
    private Page parent;

    Login() {
        setContentPane(panel1);

        nameTextField.setUI(new BasicTextFieldUI());
        passwordField.setUI(new BasicTextFieldUI());

        loginButton.setUI(new BasicButtonUI());

        loginButton.addActionListener(e -> {
            String inputName = nameTextField.getText();
            String inputPassword = String.valueOf(passwordField.getPassword());
            if (name.equalsIgnoreCase(inputName) && password.equals(inputPassword)) {
                login();
               return;
            }

            JOptionPane.showMessageDialog(null, "Wrong user name or password");
        });

        passwordField.addActionListener((e) -> loginButton.doClick());
    }

    abstract void login();

    public JFrame getFrame() {
        return this;
    }
}
