package frontend;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

public class Navigator {

    private static final Stack<Page> pages = new Stack<>();

    public static void goTo(Page page)
    {
        JFrame frame = page.getFrame();
        frame.setVisible(true);
        frame.setSize(450, 300);

        if(! pages.isEmpty()) {
            pages.peek().getFrame().setVisible(false);
        }


        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Navigator.back();
                }
            });

        pages.push(page);
    }

    public static void back()
    {
        Page page = pages.pop();

        page.getFrame().dispose();

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
