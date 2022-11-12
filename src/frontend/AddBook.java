package frontend;

import backend.library.database.LibrarianRole;
import backend.library.database.Item;

import javax.swing.*;

public class AddBook extends JFrame implements Page {
    private JPanel panel;
    private JTextField idTextField;
    private JButton addButton;
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextField publisherTextField;
    private JTextField quantityTextField;

    public AddBook(LibrarianRole role) {
        setContentPane(panel);
        setTitle("Add Book");

        addButton.addActionListener(e -> {
            String title = titleTextField.getText();
            String id = idTextField.getText();
            String quantity = quantityTextField.getText();
            String author = authorTextField.getText();
            String publisher = publisherTextField.getText();

            if (author.trim().equals("") || title.trim().equals("") || publisher.trim().equals("") || quantity.trim().equals("") || id.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Some fields are empty");
                return;
            }

            try {
                Integer.parseInt(quantity);
            }catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "You should enter a valid numeric value in \"No of copies\" field");
                return;
            }

            if (sameId(role.getListOfBooks(), id)) {
                JOptionPane.showMessageDialog(null, "Book with id = " + id + " already exists!");

            } else {
                role.addBook(id, title, author, publisher, Integer.parseInt(quantity));

                JOptionPane.showMessageDialog(null, "The book with id = " + id + " has been successfully added.");
                titleTextField.setText("");
                idTextField.setText("");
                quantityTextField.setText("");
                authorTextField.setText("");
                publisherTextField.setText("");
            }
        });
    }

    private boolean sameId(Item[] items, String id) {
        for (Item item : items) {
            if (id.equals(item.getSearchKey()))
                return true;
        }
        return false;
    }

    public JFrame getjFrame() {
        return this;
    }
}
