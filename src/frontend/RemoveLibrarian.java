package frontend;

import backend.library.database.AdminRole;
import backend.library.database.Savable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveLibrarian extends JFrame implements Page {
    private JPanel panel;
    private JTextField idTextField;
    private JButton removeButton;

    public RemoveLibrarian(AdminRole role) {
        setContentPane(panel);
        setTitle("Remove Librarian");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();

                if (!RemoveLibrarian.this.sameId(role.getListOfLibrarians(), id)) {
                    JOptionPane.showMessageDialog(null, "The librarian with id = " + id + " doesn't exist");
                } else {

                    role.removeLibrarian(id);
                    JOptionPane.showMessageDialog(null, "The librarian with id = " + id + " has been removed");
                    idTextField.setText("");
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
