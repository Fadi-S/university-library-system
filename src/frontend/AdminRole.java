package frontend;

import javax.swing.*;

public class AdminRole implements Page {
    private JButton addLibrarianButton;
    private JButton ViewLibrarian;
    private JButton RemoveLibrarian;
    private JButton logout;
    private JPanel panel4;
    private JFrame frame;


    public AdminRole() {
        frame = new JFrame("Admin Role");
        frame.setContentPane(panel4);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addLibrarianButton.addActionListener(e -> Navigator.goTo(new AddLibrarian()));

        ViewLibrarian.addActionListener(e -> Navigator.goTo(new ViewLibrarian()));

        RemoveLibrarian.addActionListener(e -> Navigator.goTo(new RemoveLibrarian()));

        logout.addActionListener(e -> {
            // TODO save data
            Navigator.exit();
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
