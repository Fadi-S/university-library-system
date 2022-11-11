package frontend;

import frontend.auth.AdminLogin;
import frontend.auth.LibrarianLogin;

import javax.swing.*;

public class LibrarySystemWindow extends JFrame implements Page {
    private JPanel mainPanel;
    private JButton adminRoleButton;
    private JButton librarianRoleButton;

    public LibrarySystemWindow() {
        super("Library System");

        adminRoleButton.addActionListener(e -> Navigator.goTo(new AdminLogin()));

        librarianRoleButton.addActionListener(e -> Navigator.goTo(new LibrarianLogin()));
    }

    public void render()
    {
        setContentPane(mainPanel);
        setTitle("Library system");
        Navigator.goTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return this;
    }
}
