package frontend;

import backend.library.database.LibrarianRole;
import backend.library.StudentBook;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;
import java.time.format.DateTimeFormatter;

public class ViewBorrowedBooks implements Page {
    private JFrame frame;
    private JPanel panel;
    private JTable table;

    public ViewBorrowedBooks(LibrarianRole role) {
        frame = new JFrame("View Borrowed Books");
        frame.setContentPane(panel);

        StudentBook[] studentBooks = role.getListOfBorrowingOperations();
        String[][] data = new String[studentBooks.length][3];

        for (int i=0; i <studentBooks.length; i++) {
            data[i][0] = studentBooks[i].getStudentId();
            data[i][1] = studentBooks[i].getBookId();
            data[i][2] = studentBooks[i].getBorrowDate().format(DateTimeFormatter.ISO_DATE);
        }

        String[] columns = {
            "Student ID",
            "Book ID",
            "Borrow Date"
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
    public JFrame getjFrame() {
        return frame;
    }
}
