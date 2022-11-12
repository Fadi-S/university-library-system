package frontend.librarian;

import backend.library.database.LibrarianRole;
import frontend.Page;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.time.LocalDate;

public class BorrowBook implements Page {

    private final JFrame frame;
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JButton currentDateButton;
    private JButton borrowButton;
    private JPanel panel;
    private JPanel datePickerPanel;

    private JDatePicker datePicker;

    public BorrowBook(LibrarianRole role) {
        frame = new JFrame("Borrow Book");
        frame.setContentPane(panel);

        datePicker = new JDatePicker();
        datePickerPanel.add(datePicker);

        borrowButton.setUI(new BasicButtonUI());
        currentDateButton.setUI(new BasicButtonUI());

        currentDateButton.addActionListener((e) -> {
            LocalDate now = LocalDate.now();
            datePicker.getModel().setSelected(true);
            datePicker.getModel().setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
        });

        borrowButton.addActionListener((e) -> {
            String bookID = bookIDTextField.getText();
            String studentID = studentIDTextField.getText();
            DateModel<?> model = datePicker.getModel();

            if (bookID.isBlank() || studentID.isBlank() || !model.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }
            LocalDate date = LocalDate.of(model.getYear(), model.getMonth()+1, model.getDay());

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
        LocalDate now = LocalDate.now();
        datePicker.getModel().setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
