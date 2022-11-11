package frontend.librarian;

import backend.library.database.LibrarianRole;
import frontend.Page;
import frontend.utils.SearchSavables;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class AddBook implements Page {
    private JPanel panel;
    private JTextField idTextField;
    private JButton addButton;
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextField publisherTextField;
    private JTextField quantityTextField;

    private final JFrame frame;

    public AddBook(LibrarianRole role) {
        frame = new JFrame("Add Book");
        frame.setContentPane(panel);

        addButton.setUI(new BasicButtonUI());
        addButton.addActionListener(e -> {
            String title = titleTextField.getText();
            String id = idTextField.getText();
            String quantity = quantityTextField.getText();
            String author = authorTextField.getText();
            String publisher = publisherTextField.getText();

            if (author.isBlank() || title.isBlank() || publisher.isBlank() || quantity.isBlank() || id.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Some fields are empty");
                return;
            }

            if(! isValidPositiveNumber(quantity)) {
                JOptionPane.showMessageDialog(frame, "You should enter a valid numeric value in \"No of copies\" field");
                return;
            }

            if (SearchSavables.handle(role.getListOfBooks(), id) != null) {
                JOptionPane.showMessageDialog(frame, "Book with id = " + id + " already exists!");
                return;
            }

            role.addBook(id, title, author, publisher, Integer.parseInt(quantity));

            JOptionPane.showMessageDialog(frame, "The book with id = " + id + " has been successfully added.");
            clearForm();
        });
    }

    private boolean isValidPositiveNumber(String number) {
        try {
            int n = Integer.parseInt(number);
            if(n < 0) {
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private void clearForm()
    {
        titleTextField.setText("");
        idTextField.setText("");
        quantityTextField.setText("");
        authorTextField.setText("");
        publisherTextField.setText("");
    }

    public JFrame getFrame() {
        return frame;
    }
}
