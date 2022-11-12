package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySystemWindow extends JFrame implements Page {
    private JPanel mainPanel;
    private JButton adminBtn;
    private JButton librarianBtn;

    public LibrarySystemWindow() {
        setTitle("Library System");
        adminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new AdminLogin());
            }
        });

        librarianBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new LibrarianLogin());
            }
        });

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Pages.open(this);
    }

    public JFrame getjFrame() {
        return this;
    }
}
