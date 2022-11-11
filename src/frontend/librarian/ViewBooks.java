package frontend.librarian;

import backend.library.utils.Book;
import backend.library.users.LibrarianRole;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;

public class ViewBooks implements Page {
    private JTable table;
    private JPanel panel;
    private JFrame frame;

    public ViewBooks() {
        frame = new JFrame("View Books");
        frame.setContentPane(panel);

        LibrarianRole role = new LibrarianRole();

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
        table.setUI(new BasicTableUI());
        table.setBounds(30, 40, 200, 300);

        frame.add(new JScrollPane(table));
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
