package frontend.admin;

import backend.library.database.Savable;
import backend.library.users.AdminRole;
import frontend.Page;
import frontend.utils.SearchSavables;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class AddLibrarian implements Page {
    private JPanel panel;
    private JTextField IDTextField;
    private JButton addButton;
    private JTextField NameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    String name;
    String id;
    String phoneNumber;
    String address;
    String email;

    private final JFrame frame;

    public AddLibrarian() {
        frame = new JFrame("Add Librarian");
        frame.setContentPane(panel);

        addButton.setUI(new BasicButtonUI());
        addButton.addActionListener(e -> {
            AdminRole role = new AdminRole();
            name = NameTextField.getText();
            id = IDTextField.getText();
            phoneNumber = phoneTextField.getText();
            email = emailTextField.getText();
            address = addressTextField.getText();

            if (email.isBlank() || name.isBlank() || address.isBlank() || phoneNumber.isBlank() || id.isBlank()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled");
                return;
            }

            if (SearchSavables.handle(role.getListOfLibrarians(), id) != null) {
                JOptionPane.showMessageDialog(frame, "ID number= " + id + " is already exist");
                return;
            }

            role.addLibrarian(id, name, email, address, phoneNumber);
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
