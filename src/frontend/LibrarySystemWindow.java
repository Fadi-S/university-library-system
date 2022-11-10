package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySystemWindow extends JFrame implements Node {
    private JPanel panel1;
    private JButton adminRoleButton;
    private JButton librarianRoleButton;

    private LibrarySystemWindow(){
    setContentPane(panel1);
    setTitle("Library system");
    setSize(450,300);
    setVisible(true);

        adminRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminLogin adminLogin=new AdminLogin();
                adminLogin.setParentNode(getParentNode());


            }
        });
        librarianRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LibrarianLogin librarianLogin=new LibrarianLogin();
                librarianLogin.setParentNode(getParentNode());


            }
        });
    }
    public static void main(String[] args) {
        LibrarySystemWindow librarySystemWindow=new LibrarySystemWindow();
    }

    @Override
    public void setParentNode(Node n) {

    }

    @Override
    public Node getParentNode() {
        return this;
    }
}
