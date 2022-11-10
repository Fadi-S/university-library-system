package frontend;

import backend.library.users.AdminRole;
import frontend.validation.IsRequiredField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian extends JFrame implements Node {
    private JPanel panel8;
    private JTextField IDtextField1;
    private JButton addButton;
    private JTextField NametextField2;
    private JTextField EmailTextField3;
    private JTextField AddressTextField4;
    private JTextField PhoneTextField;
    Node parent;


    public AddLibrarian(){
        setContentPane(panel8);
        setTitle("View Librarian");
        setSize(450,300);
        setVisible(true);

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


    @Override
    public void setParentNode(Node n) {
        this.parent=n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
