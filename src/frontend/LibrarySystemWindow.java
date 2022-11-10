package frontend;

import frontend.auth.AdminLogin;
import frontend.auth.LibrarianLogin;

import javax.swing.*;

public class LibrarySystemWindow extends JFrame implements Node {
    private JPanel mainPanel;
    private JButton adminRoleButton;
    private JButton librarianRoleButton;

    public LibrarySystemWindow() {
        super("Library System");

        adminRoleButton.addActionListener(e -> {
            setVisible(false);
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setParentNode(getParentNode());
        });

        librarianRoleButton.addActionListener(e -> {
            setVisible(false);
            LibrarianLogin librarianLogin = new LibrarianLogin();
            librarianLogin.setParentNode(getParentNode());
        });
    }

    public void render()
    {
        setContentPane(mainPanel);
        setTitle("Library system");
        setSize(450, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void setParentNode(Node n) {

    }

    @Override
    public Node getParentNode() {
        return this;
    }
}
