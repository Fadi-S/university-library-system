package frontend.librarian;

import frontend.Navigator;
import frontend.Page;

import javax.swing.*;
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
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setTitle("Librarian Role");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addBookButton.addActionListener(this::addBook);
        viewBooksButton.addActionListener(this::viewBooks);
        borrowBookButton.addActionListener(this::borrowBook);
        viewBorrowedBooksButton.addActionListener(this::viewBorrowedBooks);
        returnBookButton.addActionListener(this::returnBook);
        logoutButton.addActionListener(this::logout);
    }

    private void addBook(ActionEvent e) {

    }

    private void viewBooks(ActionEvent e) {
        Navigator.goTo(new ViewBooks());
    }

    private void borrowBook(ActionEvent e) {

    }

    private void viewBorrowedBooks(ActionEvent e) {

    }

    private void returnBook(ActionEvent e) {

    }

    private void logout(ActionEvent e) {

    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
