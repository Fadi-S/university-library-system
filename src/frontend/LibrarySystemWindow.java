package frontend;

import frontend.auth.AdminLogin;
import frontend.auth.LibrarianLogin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class LibrarySystemWindow implements Page {
    private JPanel mainPanel;
    private JButton adminRoleButton;
    private JButton librarianRoleButton;
    private JFrame frame;

    public LibrarySystemWindow() {
        frame = new JFrame("Library System");

        adminRoleButton.setUI(new BasicButtonUI());
        adminRoleButton.addActionListener(e -> Navigator.goTo(new AdminLogin()));

        librarianRoleButton.setUI(new BasicButtonUI());
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
