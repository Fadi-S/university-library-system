package frontend;

import javax.swing.*;

public class AdminRole extends JFrame implements Node {
    private JButton addLibrarianButton;
    private JButton ViewLibrarian;
    private JButton RemoveLibrarian;
    private JButton logout;
    private JPanel panel4;
    Node parent;

    public AdminRole() {
        setContentPane(panel4);
        setTitle("Admin Role");
        setSize(450,300);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addLibrarianButton.addActionListener(e -> {
            setVisible(false);
            new AddLibrarian();
        });

        ViewLibrarian.addActionListener(e -> {
            setVisible(false);
            new ViewLibrarian();
        });

        RemoveLibrarian.addActionListener(e -> {
            setVisible(false);
            new RemoveLibrarian();
        });

        logout.addActionListener(e -> {
            setVisible(false);
            new Logout();
        });
    }

    @Override
    public void setParentNode(Node n) {
        this.parent = n;
    }

    @Override
    public Node getParentNode() {
        return this;
    }
}
