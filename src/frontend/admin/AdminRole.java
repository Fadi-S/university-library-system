package frontend.admin;

import frontend.utils.Navigator;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class AdminRole implements Page {
    private JButton addLibrarianButton;
    private JButton viewLibrarianButton;
    private JButton removeLibrarianButton;
    private JButton logoutButton;
    private JPanel panel;
    private final JFrame frame;


    public AdminRole() {
        frame = new JFrame("Admin Role");
        frame.setContentPane(panel);

        backend.library.database.AdminRole role = new backend.library.database.AdminRole();

        addLibrarianButton.addActionListener(e -> Navigator.goTo(new AddLibrarian(role)));
        addLibrarianButton.setUI(new BasicButtonUI());

        viewLibrarianButton.addActionListener(e -> Navigator.goTo(new ViewLibrarian(role)));
        viewLibrarianButton.setUI(new BasicButtonUI());

        removeLibrarianButton.addActionListener(e -> Navigator.goTo(new RemoveLibrarian(role)));
        removeLibrarianButton.setUI(new BasicButtonUI());

        logoutButton.addActionListener(e -> {
            role.logout();
            JOptionPane.showMessageDialog(frame,"All data has been saved");
            Navigator.back();
        });
        logoutButton.setUI(new BasicButtonUI());
    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean closable()
    {
        return false;
    }
}
