package frontend.auth;

import frontend.Navigator;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

public abstract class Login implements Page {
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JFrame frame;

    String name;
    String password;

    Login() {
        frame = new JFrame();
        frame.setContentPane(panel1);

        nameTextField.setUI(new BasicTextFieldUI());
        passwordField.setUI(new BasicTextFieldUI());

        loginButton.setUI(new BasicButtonUI());

        loginButton.addActionListener(e -> {
            String inputName = nameTextField.getText();
            String inputPassword = String.valueOf(passwordField.getPassword());
            if (name.equalsIgnoreCase(inputName) && password.equals(inputPassword)) {
               Navigator.goTo(nextPage());
               return;
            }

            JOptionPane.showMessageDialog(frame, "Wrong user name or password");
        });

        passwordField.addActionListener((e) -> loginButton.doClick());
    }

    abstract Page nextPage();

    public JFrame getFrame() {
        return frame;
    }
}
