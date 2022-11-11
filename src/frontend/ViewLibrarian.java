package frontend;

import javax.swing.*;

public class ViewLibrarian extends JFrame implements Page {
    private JPanel panel5;
    public ViewLibrarian(){
        setContentPane(panel5);
        setTitle("View Librarian");
    }

    public JFrame getFrame() {
        return this;
    }
}
