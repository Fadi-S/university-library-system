package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRole extends JFrame implements Page {
    private JButton addLibrarianButton;
    private JButton viewLibrarianButton;
    private JButton removeLibrarianButton;
    private JButton logoutButton;
    private JPanel panel;

    public AdminRole() {
        setContentPane(panel);
        setTitle("Admin Role");

        backend.library.database.AdminRole role = new backend.library.database.AdminRole();

        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new AddLibrarian(role));
            }
        });

        viewLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new ViewLibrarian(role));
            }
        });

        removeLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new RemoveLibrarian(role));
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role.logout();
                JOptionPane.showMessageDialog(null,"All data has been saved");
                Pages.close();
            }
        });
    }

    public JFrame getjFrame() {
        return this;
    }

    public boolean closable()
    {
        return false;
    }
}
