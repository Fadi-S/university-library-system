package frontend;

import javax.swing.*;

public interface Page {
    JFrame getjFrame();

    default boolean skip() {
        return false;
    }

    default boolean close() {
        return true;
    }
}