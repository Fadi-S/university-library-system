package frontend;

import backend.library.database.LibrarianRole;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.time.LocalDate;

public class ReturnBook extends JFrame implements Page {
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JButton returnButton;
    private JPanel panel;
    private JPanel returnDatePanel;

    private JDatePicker datePicker;

    public ReturnBook(LibrarianRole role) {
        setContentPane(panel);
        setTitle("Return Book");

        datePicker = new JDatePicker();
        returnDatePanel.add(datePicker);

        returnButton.addActionListener((e) -> {
            String bookID = bookIDTextField.getText();
            String studentID = studentIDTextField.getText();
            DateModel<?> model = datePicker.getModel();

            if (bookID.trim().equals("") || studentID.trim().equals("") || !model.isSelected()) {
                JOptionPane.showMessageDialog(null, "Some fields are empty");
                return;
            }
            LocalDate date = LocalDate.of(model.getYear(), model.getMonth()+1, model.getDay());

            double lateFee = role.returnBook(studentID, bookID, date);

            JOptionPane.showMessageDialog(null, "The student with id = " + studentID + " should pay a return fee of " + lateFee + " US dollars for the book with id " + bookID);

            studentIDTextField.setText("");
            bookIDTextField.setText("");
            LocalDate now = LocalDate.now();
            datePicker.getModel().setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
        });
    }
    @Override
    public JFrame getjFrame() {
        return this;
    }
}
