package frontend.admin;

import backend.library.database.AdminRole;
import frontend.Page;
import frontend.utils.SearchSavables;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class RemoveLibrarian implements Page {
    private JPanel panel;
    private JTextField idTextField;
    private JButton removeButton;
    private final JFrame frame;

    public RemoveLibrarian(AdminRole role) {
        frame = new JFrame("Remove Librarian");
        frame.setContentPane(panel);

        removeButton.setUI(new BasicButtonUI());
        removeButton.addActionListener(e -> {
            String id = idTextField.getText();

            if (SearchSavables.handle(role.getListOfLibrarians(), id) == null) {
                JOptionPane.showMessageDialog(frame, "The librarian with id = " + id + " doesn't exist");
                return;
            }

            role.removeLibrarian(id);
            JOptionPane.showMessageDialog(frame, "The librarian with id = " + id + " has been removed");
            idTextField.setText("");
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
