package frontend;

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

        addLibrarianButton.addActionListener(e -> Navigator.goTo(new AddLibrarian()));
        addLibrarianButton.setUI(new BasicButtonUI());

        viewLibrarianButton.addActionListener(e -> Navigator.goTo(new ViewLibrarian()));
        viewLibrarianButton.setUI(new BasicButtonUI());

        removeLibrarianButton.addActionListener(e -> Navigator.goTo(new RemoveLibrarian()));
        removeLibrarianButton.setUI(new BasicButtonUI());

        logoutButton.addActionListener(e -> {
            // TODO save data
            Navigator.exit();
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
