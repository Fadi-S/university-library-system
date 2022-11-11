package frontend;

import frontend.auth.AdminLogin;
import frontend.auth.LibrarianLogin;

import javax.swing.*;

public class LibrarySystemWindow implements Page {
    private JPanel mainPanel;
    private JButton adminRoleButton;
    private JButton librarianRoleButton;

    private JFrame frame;

    public LibrarySystemWindow() {
        frame = new JFrame("Library System");

        adminRoleButton.addActionListener(e -> Navigator.goTo(new AdminLogin()));

        librarianRoleButton.addActionListener(e -> Navigator.goTo(new LibrarianLogin()));
    }

    public void render()
    {
        frame.setContentPane(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Navigator.goTo(this);
    }

    public JFrame getFrame() {
        return frame;
    }
}
