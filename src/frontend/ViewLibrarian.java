package frontend;

import javax.swing.*;

public class ViewLibrarian implements Page {
    private JPanel panel5;
    private JFrame frame;
    public ViewLibrarian(){
        frame = new JFrame("View Librarian");

        frame.setContentPane(panel5);
    }

    public JFrame getFrame() {
        return frame;
    }
}
