package frontend;

import javax.swing.*;

public class AddLibrarian extends JFrame implements Node {
    private JPanel panel8;
    Node parent;

    public AddLibrarian(){
        setContentPane(panel8);
        setTitle("View Librarian");
        setSize(450,300);
        setVisible(true);
    }

    @Override
    public void setParentNode(Node n) {
        this.parent=n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
