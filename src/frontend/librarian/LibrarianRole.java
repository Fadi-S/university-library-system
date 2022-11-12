package frontend.librarian;

import frontend.utils.Navigator;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

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

        backend.library.database.LibrarianRole role = new backend.library.database.LibrarianRole();

        addBookButton.addActionListener((e) -> Navigator.goTo(new AddBook(role)));
        addBookButton.setUI(new BasicButtonUI());

        viewBooksButton.addActionListener((e) -> Navigator.goTo(new ViewBooks(role)));
        viewBooksButton.setUI(new BasicButtonUI());

        borrowBookButton.addActionListener((e) -> Navigator.goTo(new BorrowBook(role)));
        borrowBookButton.setUI(new BasicButtonUI());

        viewBorrowedBooksButton.addActionListener((e) -> Navigator.goTo(new ViewBorrowedBooks(role)));
        viewBorrowedBooksButton.setUI(new BasicButtonUI());

        returnBookButton.addActionListener((e) -> Navigator.goTo(new ReturnBook(role)));
        returnBookButton.setUI(new BasicButtonUI());

        logoutButton.addActionListener((e) -> {
            role.logout();
            JOptionPane.showMessageDialog(frame,"All data has been saved");
            Navigator.back();
        });
        logoutButton.setUI(new BasicButtonUI());
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
