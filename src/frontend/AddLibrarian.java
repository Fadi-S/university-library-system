package frontend;

import backend.library.database.Savable;
import backend.library.users.AdminRole;

import javax.swing.*;

public class AddLibrarian implements Page {
    private JPanel panel8;
    private JTextField IDtextField1;
    private JButton addButton;
    private JTextField NametextField2;
    private JTextField EmailTextField3;
    private JTextField AddressTextField4;
    private JTextField PhoneTextField;
    String name;
    String id;
    String phoneNumber;
    String address;
    String email;

    private JFrame frame;

    public AddLibrarian() {
        frame = new JFrame("Add Librarian");
        frame.setContentPane(panel8);

        addButton.addActionListener(e -> {
            AdminRole role = new AdminRole();
            name = NametextField2.getText();
            id = IDtextField1.getText();
            phoneNumber = PhoneTextField.getText();
            email = EmailTextField3.getText();
            address = AddressTextField4.getText();

            if (email.trim().equals("") ||
                    name.trim().equals("") ||
                    address.trim().equals("") ||
                    phoneNumber.trim().equals("") ||
                    id.trim().equals("")) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled");
                return;
            }

            if (SameID(id, role.getListOfLibrarians())) {
                JOptionPane.showMessageDialog(frame, "ID number= " + id + " is already exist");
                return;
            }
            role.addLibrarian(id, name, email, address, phoneNumber);

        });
    }

    public Boolean SameID(String id, Savable[] role) {
        for (Savable savable : role) {
            if (id.equals(savable.getSearchKey()))
                return true;
        }
        return false;
    }

    public JFrame getFrame() {
        return frame;
    }
}
