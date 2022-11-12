package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianRole extends JFrame implements Page {
    private JButton addBookButton;
    private JButton viewBooksButton;
    private JButton borrowBookButton;
    private JButton viewBorrowedBooksButton;
    private JButton returnBookButton;
    private JButton logoutButton;
    private JPanel panel;

    public LibrarianRole() {
        setContentPane(panel);
        setTitle("Librarian Role");

        backend.library.database.LibrarianRole role = new backend.library.database.LibrarianRole();

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new AddBook(role));
            }
        });

        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new ViewBooks(role));
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new BorrowBook(role));
            }
        });

        viewBorrowedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new ViewBorrowedBooks(role));
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pages.open(new ReturnBook(role));
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role.logout();
                JOptionPane.showMessageDialog(null, "All data has been saved");
                Pages.close();
            }
        });
    }

    @Override
    public JFrame getjFrame() {
        return this;
    }

    @Override
    public boolean close() {
        return false;
    }
}
