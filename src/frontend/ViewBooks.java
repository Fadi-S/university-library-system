package frontend;

import backend.library.utils.Book;
import backend.library.database.LibrarianRole;

import javax.swing.*;

public class ViewBooks extends JFrame implements Page {
    private JTable table;
    private JPanel panel;

    public ViewBooks(LibrarianRole role) {
        setContentPane(panel);
        setTitle("View Books");

        Book[] books = role.getListOfBooks();
        String[][] data = new String[books.length][5];

        for (int i=0; i <books.length; i++) {
            data[i][0] = books[i].getBookId();
            data[i][1] = books[i].getTitle();
            data[i][2] = books[i].getAuthorName();
            data[i][3] = books[i].getPublisherName();
            data[i][4] = String.valueOf(books[i].getQuantity());
        }

        String[] columns = {
                "Book ID",
                "Title",
                "Author Name",
                "Publisher",
                "No Of Copies"
        };
        table = new JTable(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setBounds(50, 50, 300, 350);

        add(new JScrollPane(table));
    }

    @Override
    public JFrame getjFrame() {
        return this;
    }
}
