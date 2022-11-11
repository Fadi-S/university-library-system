package frontend;

import javax.swing.*;

public interface Page {
    JFrame getFrame();

    default boolean shouldSkip() {
        return false;
    }

    default boolean closable() {
        return true;
    }
}