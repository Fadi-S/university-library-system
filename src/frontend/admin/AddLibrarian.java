package frontend.admin;

import backend.library.database.AdminRole;
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

    public AddLibrarian(AdminRole role) {
        frame = new JFrame("Add Librarian");
        frame.setContentPane(panel);

        addButton.setUI(new BasicButtonUI());
        addButton.addActionListener(e -> {
            name = NameTextField.getText();
            id = IDTextField.getText();
            phoneNumber = phoneTextField.getText();
            email = emailTextField.getText();
            address = addressTextField.getText();

            if (email.isBlank() || name.isBlank() || address.isBlank() || phoneNumber.isBlank() || id.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }

            if (SearchSavables.handle(role.getListOfLibrarians(), id) != null) {
                JOptionPane.showMessageDialog(frame, "The librarian with id = " + id + " already exists!");
                return;
            }

            role.addLibrarian(id, name, email, address, phoneNumber);

            JOptionPane.showMessageDialog(frame, "The librarian with id = " + id + " has been successfully added.");
            clearForm();
        });
    }

    private void clearForm()
    {
        NameTextField.setText("");
        IDTextField.setText("");
        phoneTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
    }

    public JFrame getFrame() {
        return frame;
    }
}
