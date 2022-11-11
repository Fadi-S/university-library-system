package frontend;

import backend.library.database.Savable;
import backend.library.users.AdminRole;
import backend.library.users.LibrarianUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveLibrarian implements Page {
    private JPanel panel6;
    private JTextField IDtextField1;
    private JButton removeButton;
    private JFrame frame;

    public RemoveLibrarian() {
        frame = new JFrame("Remove Librarian");

        frame.setContentPane(panel6);


        removeButton.addActionListener(e -> {
           String id=IDtextField1.getText();
            AdminRole adminRole=new AdminRole();
           if (!searchID(id,adminRole.getListOfLibrarians())) {
               JOptionPane.showMessageDialog(null, "Id number =" + id + " doesn't exist");
           return;
           }
            adminRole.removeLibrarian(id);
            JOptionPane.showMessageDialog(null, "Id number =" + id + " has been removed");

           });
    }
    public boolean searchID(String id, Savable[] librarian)
    {
        for (Savable savable:librarian)
        {
            if (id.equals(savable.getSearchKey()))
                return true;
        }
        return false;
    }
    public JFrame getFrame() {
        return frame;
    }
}
