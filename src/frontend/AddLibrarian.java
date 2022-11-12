package frontend;

import backend.library.database.AdminRole;
import backend.library.database.Savable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian extends JFrame implements Page {
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

    public AddLibrarian(AdminRole role) {
        setTitle("Add Librarian");
        setContentPane(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = NameTextField.getText();
                id = IDTextField.getText();
                phoneNumber = phoneTextField.getText();
                email = emailTextField.getText();
                address = addressTextField.getText();

                if (email.trim().equals("") || name.trim().equals("") || address.trim().equals("") || phoneNumber.trim().equals("") || id.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty");
                } else if (AddLibrarian.this.sameId(role.getListOfLibrarians(), id)) {
                    JOptionPane.showMessageDialog(null, "The librarian with id = " + id + " already exists!");
                } else {
                    role.addLibrarian(id, name, email, address, phoneNumber);

                    JOptionPane.showMessageDialog(null, "The librarian with id = " + id + " has been successfully added.");
                    NameTextField.setText("");
                    IDTextField.setText("");
                    phoneTextField.setText("");
                    emailTextField.setText("");
                    addressTextField.setText("");
                }
            }
        });
    }

    private boolean sameId(Savable[] items, String id) {
        for (Savable savable : items) {
            if (id.equals(savable.getSearchKey()))
                return true;
        }
        return false;
    }

    public JFrame getjFrame() {
        return this;
    }
}
