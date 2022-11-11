package frontend;

import backend.library.users.AdminRole;
import frontend.validation.IsRequiredField;

import javax.swing.*;

public class AddLibrarian extends JFrame implements Page {
    private JPanel panel8;
    private JTextField IDtextField1;
    private JButton addButton;
    private JTextField NametextField2;
    private JTextField EmailTextField3;
    private JTextField AddressTextField4;
    private JTextField PhoneTextField;

    public AddLibrarian(){
        setContentPane(panel8);
        setTitle("Add Librarian");

        IDtextField1.setInputVerifier(new IsRequiredField());
        NametextField2.setInputVerifier(new IsRequiredField());
        EmailTextField3.setInputVerifier(new IsRequiredField());
        AddressTextField4.setInputVerifier(new IsRequiredField());
        PhoneTextField.setInputVerifier(new IsRequiredField());

        addButton.addActionListener(e -> {
            AdminRole role = new AdminRole();

            if(! ( IDtextField1.isValid() &&
            NametextField2.isValid() &&
            EmailTextField3.isValid() &&
            AddressTextField4.isValid() &&
            PhoneTextField.isValid() )) {

                JOptionPane.showMessageDialog(null, "All fields must be filled");
                return;
            }

            role.addLibrarian(IDtextField1.getText(),NametextField2.getText(),EmailTextField3.getText(),AddressTextField4.getText(),PhoneTextField.getText());
        });
    }

    public JFrame getFrame() {
        return this;
    }
}
