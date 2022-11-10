package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRole extends JFrame{
    private JButton addLibrarianButton;
    private JButton ViewLibrarian;
    private JButton RemoveLibrarian;
    private JButton logout;
    private JPanel panel4;

    public AdminRole() {
        setContentPane(panel4);
        setTitle("Admin Role");
        setSize(450,300);
        setVisible(true);
        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddLibrarian addLibrarian=new AddLibrarian();

            }
        });
        ViewLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewLibrarian viewLibrarian=new ViewLibrarian();
            }
        });
        RemoveLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RemoveLibrarian removeLibrarian=new RemoveLibrarian();

            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Logout logout1=new Logout();

            }
        });
    }
}
