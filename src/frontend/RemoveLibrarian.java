package frontend;

import javax.swing.*;

public class RemoveLibrarian implements Page {
    private JPanel panel6;
    private JFrame frame;

    public RemoveLibrarian() {
        frame = new JFrame("Remove Librarian");

        frame.setContentPane(panel6);
    }

    public JFrame getFrame() {
        return frame;
    }
}
