package frontend;

import javax.swing.*;

public class Logout extends JFrame implements Node {
    private JPanel panel7;
    Node parent;

    public Logout(){
        setContentPane(panel7);
        setTitle("Logout");
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
