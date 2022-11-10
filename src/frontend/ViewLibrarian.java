package frontend;

import javax.swing.*;

public class ViewLibrarian extends JFrame implements Node {
    private JPanel panel5;
    Node parent;

    public ViewLibrarian(){
        setContentPane(panel5);
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
