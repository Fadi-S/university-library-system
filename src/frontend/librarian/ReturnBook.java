package frontend.librarian;

import backend.library.database.LibrarianRole;
import frontend.Page;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.time.LocalDate;

public class ReturnBook implements Page {

    private final JFrame frame;
    private JTextField studentIDTextField;
    private JTextField bookIDTextField;
    private JButton currentDateButton;
    private JButton returnButton;
    private JPanel panel;
    private JPanel returnDatePanel;

    private JDatePicker datePicker;

    public ReturnBook(LibrarianRole role) {
        frame = new JFrame("Return Book");
        frame.setContentPane(panel);

        datePicker = new JDatePicker();
        returnDatePanel.add(datePicker);

        returnButton.setUI(new BasicButtonUI());
        currentDateButton.setUI(new BasicButtonUI());

        currentDateButton.addActionListener((e) -> {
            LocalDate now = LocalDate.now();
            datePicker.getModel().setSelected(true);
            datePicker.getModel().setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
        });

        returnButton.addActionListener((e) -> {
            String bookID = bookIDTextField.getText();
            String studentID = studentIDTextField.getText();
            DateModel<?> model = datePicker.getModel();

            if (bookID.isBlank() || studentID.isBlank() || !model.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }
            LocalDate date = LocalDate.of(model.getYear(), model.getMonth()+1, model.getDay());

            double lateFee = role.returnBook(studentID, bookID, date);

            JOptionPane.showMessageDialog(frame, "The student with id = " + studentID + " should pay a return fee of " + lateFee + " US dollars for the book with id " + bookID);

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
