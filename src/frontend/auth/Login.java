package frontend.auth;

import frontend.utils.Navigator;
import frontend.Page;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;

public abstract class Login implements Page {
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JFrame frame;

    String name;
    String password;

    Login() {
        frame = new JFrame();
        frame.setContentPane(panel1);

        nameTextField.setUI(new BasicTextFieldUI());
        passwordField.setUI(new BasicTextFieldUI());

        loginButton.setUI(new BasicButtonUI());

        passwordLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        usernameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        loginButton.addActionListener(e -> {
            String inputName = nameTextField.getText();
            String inputPassword = String.valueOf(passwordField.getPassword());
            if (name.equalsIgnoreCase(inputName) && password.equals(inputPassword)) {
               Navigator.goTo(nextPage());
               return;
            }

            JOptionPane.showMessageDialog(frame, "Wrong user name or password");

            Navigator.back();
        });

        passwordField.addActionListener((e) -> loginButton.doClick());
    }

    abstract Page nextPage();

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public boolean shouldSkip() {
        return true;
    }
}
