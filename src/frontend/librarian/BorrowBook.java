package frontend.librarian;

import backend.library.database.LibrarianRole;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowBook implements Page {

    private final JFrame frame;
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JTextField borrowDateField;
    private JButton currentDateButton;
    private JButton borrowButton;
    private JPanel panel;

    public BorrowBook(LibrarianRole role) {
        frame = new JFrame("Borrow Book");
        frame.setContentPane(panel);

        borrowButton.setUI(new BasicButtonUI());
        currentDateButton.setUI(new BasicButtonUI());

        currentDateButton.addActionListener((e) -> {
            borrowDateField.setText(
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE)
            );
        });

        borrowButton.addActionListener((e) -> {
            String bookID = bookIDTextField.getText();
            String studentID = studentIDTextField.getText();
            String borrowDate = borrowDateField.getText();

            if (bookID.isBlank() || studentID.isBlank() || borrowDate.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }
            LocalDate date = LocalDate.parse(borrowDate);

            int result = role.borrowBook(studentID, bookID, date);

            if(result == 0) {
                JOptionPane.showMessageDialog(frame, "All copies of the book with id = " + bookID + " have been borrowed and no copy is left for the student with id = " + studentID);
                return;
            }

            if(result == 1) {
                JOptionPane.showMessageDialog(frame, "Student with id = " + studentID + " has already borrowed a copy of the book with id = " + bookID + " and hasn't returned it yet.");
                return;
            }

            JOptionPane.showMessageDialog(frame, "Student with id = " + studentID + " has successfully borrowed a copy of the book with id = " + bookID);

            clearForm();
        });
    }

    private void clearForm()
    {
        studentIDTextField.setText("");
        bookIDTextField.setText("");
        borrowDateField.setText("");
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
