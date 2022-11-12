package frontend;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

public class Pages {

    private static final Stack<Page> pages = new Stack<>();

    public static void open(Page page)
    {
        if(! pages.isEmpty()) {
            pages.peek().getjFrame().setVisible(false);
        }

        JFrame frame = page.getjFrame();
        frame.setVisible(true);
        frame.setSize(400, 500);

        if(page.closable()) {
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Pages.close();
                }
            });
        }else {
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }

        pages.push(page);
    }

    public static void close() {
        if (pages.isEmpty()) {
            return;
        }

        Page page = pages.pop();

        JFrame frame = page.getjFrame();

        frame.dispose();

        if (!pages.isEmpty()) {
            Page parentPage = pages.peek();
            parentPage.getjFrame().setVisible(true);

            if (parentPage.shouldSkip()) {
                close();
            }
        }
    }
}
