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

    public RemoveLibrarian() {
        frame = new JFrame("Remove Librarian");
        frame.setContentPane(panel);

        AdminRole role = new AdminRole();

        removeButton.setUI(new BasicButtonUI());
        removeButton.addActionListener(e -> {
            String id = idTextField.getText();

            if (SearchSavables.handle(role.getListOfLibrarians(), id) == null) {
                JOptionPane.showMessageDialog(frame, "Id number =" + id + " doesn't exist");
                return;
            }

            role.removeLibrarian(id);
            JOptionPane.showMessageDialog(frame, "Id number =" + id + " has been removed");
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
