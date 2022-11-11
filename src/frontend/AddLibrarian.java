package frontend;

import backend.library.database.Savable;
import backend.library.users.AdminRole;
import backend.library.users.LibrarianUser;
import frontend.validation.IsRequiredField;

import javax.naming.Name;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AddLibrarian extends JFrame implements Node {
    private JPanel panel8;
    private JTextField IDtextField1;
    private JButton addButton;
    private JTextField NametextField2;
    private JTextField EmailTextField3;
    private JTextField AddressTextField4;
    private JTextField PhoneTextField;
    Node parent;
String name;
String id;
String phoneNumber;
String address;
String email;


    public AddLibrarian(){
        setContentPane(panel8);
        setTitle("Add Librarian");
        setSize(450,300);
        setVisible(true);
        addButton.addActionListener(e -> {
            AdminRole role = new AdminRole();
            name=NametextField2.getText();
            id=IDtextField1.getText();
            phoneNumber=PhoneTextField.getText();
            email=EmailTextField3.getText();
            address=AddressTextField4.getText();

            if( email.trim().equals("") ||
            name.trim().equals("")||
            address.trim().equals("") ||
            phoneNumber.trim().equals("") ||
            id.trim().equals("") ) {
                JOptionPane.showMessageDialog(null, "All fields must be filled");
            return;
            }
            if (SameID(id,role.getListOfLibrarians())) {
                JOptionPane.showMessageDialog(null, "ID number= " + id + " is already exist");
            return;
            }
              role.addLibrarian(id,name,email,address,phoneNumber);

        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            }
        });
    }

//    public String[] getUSerData(){
//        return data.toArray(new String[0]);
//    }
public Boolean SameID(String id, Savable[] role)
{
    for (Savable savable : role) {
        if (id.equals( savable.getSearchKey()))
            return true;
    }
    return false;
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
