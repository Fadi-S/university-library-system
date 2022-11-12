package frontend;

import backend.library.database.AdminRole;
import backend.library.users.LibrarianUser;

import javax.swing.*;

public class ViewLibrarian extends JFrame implements Page {
    private JPanel panel;

    public ViewLibrarian(AdminRole role) {
        setTitle("View Librarians");
        setContentPane(panel);

        String[] columns = {"Librarian ID", "Name", "Email", "Address", "Phone Number"};

        LibrarianUser[] librarian = role.getListOfLibrarians();
        String[][] data = new String[librarian.length][5];
        for (int i = 0; i < librarian.length; i++) {
            data[i][0] = librarian[i].getId();
            data[i][1] = librarian[i].getName();
            data[i][2] = librarian[i].getEmail();
            data[i][3] = librarian[i].getAddress();
            data[i][4] = librarian[i].getPhoneNumber();
        }
        JTable table = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.getTableHeader().setReorderingAllowed(false);

        table.setBounds(50, 50, 300, 350);
        add(new JScrollPane(table));
    }

    public JFrame getjFrame() {
        return this;
    }
}
