package frontend.librarian;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LibrarianRole {
    private JButton addBookButton;
    private JButton viewBooksButton;
    private JButton borrowBookButton;
    private JButton viewBorrowedBooksButton;
    private JButton returnBookButton;
    private JButton logoutButton;
    private JPanel panel;
    private final JFrame frame;

    public LibrarianRole() {
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setTitle("Librarian Role");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setVisible(true);

        addBookButton.addActionListener(this::addBook);
        viewBooksButton.addActionListener(this::viewBooks);
        borrowBookButton.addActionListener(this::borrowBook);
        viewBorrowedBooksButton.addActionListener(this::viewBorrowedBooks);
        returnBookButton.addActionListener(this::returnBook);
        logoutButton.addActionListener(this::logout);
    }

    private void addBook(ActionEvent e) {
        hide();

    }

    private void viewBooks(ActionEvent e) {
        hide();
    }

    private void borrowBook(ActionEvent e) {
        hide();
    }

    private void viewBorrowedBooks(ActionEvent e) {
        hide();
    }

    private void returnBook(ActionEvent e) {
        hide();
    }

    private void logout(ActionEvent e) {
        frame.dispose();
    }

    private void hide() {
        frame.setVisible(false);
    }
}
