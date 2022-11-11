package frontend.librarian;

import backend.library.database.LibrarianRole;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReturnBook implements Page {

    private final JFrame frame;
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JTextField returnDateField;
    private JButton currentDateButton;
    private JButton returnButton;
    private JPanel panel;

    public ReturnBook(LibrarianRole role) {
        frame = new JFrame("Borrow Book");
        frame.setContentPane(panel);

        returnButton.setUI(new BasicButtonUI());
        currentDateButton.setUI(new BasicButtonUI());

        currentDateButton.addActionListener((e) -> {
            returnDateField.setText(
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE)
            );
        });

        returnButton.addActionListener((e) -> {
            String bookID = bookIDTextField.getText();
            String studentID = studentIDTextField.getText();
            String borrowDate = returnDateField.getText();

            if (bookID.isBlank() || studentID.isBlank() || borrowDate.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }
            LocalDate date = LocalDate.parse(borrowDate);

            double lateFee = role.returnBook(studentID, bookID, date);

            JOptionPane.showMessageDialog(frame, "The student with id = " + studentID + " should pay a return fee of " + lateFee + " US dollars for the book with id " + bookID);

            clearForm();
        });
    }

    private void clearForm()
    {
        studentIDTextField.setText("");
        bookIDTextField.setText("");
        returnDateField.setText("");
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
