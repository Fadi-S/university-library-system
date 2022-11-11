package frontend.librarian;

import frontend.utils.Navigator;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.ActionEvent;

public class LibrarianRole implements Page {
    private JButton addBookButton;
    private JButton viewBooksButton;
    private JButton borrowBookButton;
    private JButton viewBorrowedBooksButton;
    private JButton returnBookButton;
    private JButton logoutButton;
    private JPanel panel;
    private final JFrame frame;

    public LibrarianRole() {
        frame = new JFrame("Librarian Role");
        frame.setContentPane(panel);

        addBookButton.addActionListener((e) -> Navigator.goTo(null));
        addBookButton.setUI(new BasicButtonUI());

        viewBooksButton.addActionListener((e) -> Navigator.goTo(new ViewBooks()));
        viewBooksButton.setUI(new BasicButtonUI());

        borrowBookButton.addActionListener((e) -> Navigator.goTo(null));
        borrowBookButton.setUI(new BasicButtonUI());

        viewBorrowedBooksButton.addActionListener((e) -> Navigator.goTo(new ViewBorrowedBooks()));
        viewBorrowedBooksButton.setUI(new BasicButtonUI());

        returnBookButton.addActionListener((e) -> Navigator.goTo(null));
        returnBookButton.setUI(new BasicButtonUI());

        logoutButton.addActionListener(this::logout);
        logoutButton.setUI(new BasicButtonUI());
    }

    private void logout(ActionEvent e) {
        // TODO Save data

        Navigator.back();
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public boolean closable() {
        return false;
    }
}
