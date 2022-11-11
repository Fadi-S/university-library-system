package frontend;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

public class Navigator {

    private static final Stack<Page> pages = new Stack<>();

    public static void goTo(Page page)
    {
        if(! pages.isEmpty()) {
            pages.peek().getFrame().setVisible(false);
        }

        JFrame frame = page.getFrame();
        frame.setVisible(true);
        frame.setSize(400, 500);

        if(frame.getDefaultCloseOperation() != JFrame.DO_NOTHING_ON_CLOSE)
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Navigator.back();
                }
            });

        pages.push(page);
    }

    public static void back()
    {
        if(pages.isEmpty()) {
            return;
        }

        Page page = pages.pop();

        JFrame frame = page.getFrame();

        if(frame.getDefaultCloseOperation() != JFrame.DO_NOTHING_ON_CLOSE)
            frame.dispose();

        if(! pages.isEmpty()) {
            pages.peek().getFrame().setVisible(true);
        }
    }

    public static void exit()
    {
        while(! pages.isEmpty()) {
            pages.pop().getFrame().dispose();
        }
    }
}
