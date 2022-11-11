package frontend;

import javax.swing.*;

public class AdminRole extends JFrame implements Page {
    private JButton addLibrarianButton;
    private JButton ViewLibrarian;
    private JButton RemoveLibrarian;
    private JButton logout;
    private JPanel panel4;
    Page parent;

    public AdminRole() {
        setContentPane(panel4);
        setTitle("Admin Role");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addLibrarianButton.addActionListener(e -> Navigator.goTo(new AddLibrarian()));

        ViewLibrarian.addActionListener(e -> Navigator.goTo(new ViewLibrarian()));

        RemoveLibrarian.addActionListener(e -> Navigator.goTo(new RemoveLibrarian()));

        logout.addActionListener(e -> {
            // TODO logout
        });
    }

    public JFrame getFrame() {
        return this;
    }
}
