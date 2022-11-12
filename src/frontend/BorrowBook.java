package frontend;

import backend.library.database.LibrarianRole;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BorrowBook extends JFrame implements Page {
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JButton borrowButton;
    private JPanel panel;
    private JPanel datePickerPanel;

    private JDatePicker datePicker;

    public BorrowBook(LibrarianRole role) {
        setContentPane(panel);
        setTitle("Borrow Book");

        datePicker = new JDatePicker();
        datePickerPanel.add(datePicker);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookID = bookIDTextField.getText();
                String studentID = studentIDTextField.getText();
                DateModel<?> model = datePicker.getModel();

                if (bookID.trim().equals("") || studentID.trim().equals("") || !model.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty");
                    return;
                }

                LocalDate date = LocalDate.of(model.getYear(), model.getMonth() + 1, model.getDay());

                int result = role.borrowBook(studentID, bookID, date);

                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "All copies of the book with id = " + bookID + " have been borrowed and no copy is left for the student with id = " + studentID);
                } else if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Student with id = " + studentID + " has already borrowed a copy of the book with id = " + bookID + " and hasn't returned it yet.");
                } else {
                    JOptionPane.showMessageDialog(null, "Student with id = " + studentID + " has successfully borrowed a copy of the book with id = " + bookID);

                    studentIDTextField.setText("");
                    bookIDTextField.setText("");
                    LocalDate now = LocalDate.now();
                    datePicker.getModel().setDate(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
                }
            }
        });
    }

    @Override
    public JFrame getjFrame() {
        return this;
    }
}
