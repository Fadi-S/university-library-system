package frontend;

import javax.swing.*;

public class RemoveLibrarian extends JFrame implements Node{
    private JPanel panel6;
    Node parent;

    public RemoveLibrarian(){
        setContentPane(panel6);
        setTitle("Remove Librarian");
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
