package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRole extends JFrame implements Node{
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
        addLibrarianButton.addActionListener(e -> {
            setVisible(false);
            AddLibrarian addLibrarian=new AddLibrarian();
            addLibrarian.setParentNode(getParentNode());
        });
        ViewLibrarian.addActionListener(e -> {
            setVisible(false);
            ViewLibrarian viewLibrarian=new ViewLibrarian();
        });
        RemoveLibrarian.addActionListener(e -> {
            setVisible(false);
            RemoveLibrarian removeLibrarian=new RemoveLibrarian();

        });
        logout.addActionListener(e -> {
            setVisible(false);
            Logout logout1=new Logout();

        });
    }

    @Override
    public void setParentNode(Node n) {

    }

    @Override
    public Node getParentNode() {
        return this;
    }
}
