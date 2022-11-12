package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySystem extends JFrame implements Page {
    private JPanel panel;
    private JButton adminBtn;
    private JButton librarianBtn;

    public LibrarySystem() {
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

        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Pages.open(this);
    }

    public JFrame getjFrame() {
        return this;
    }
}
