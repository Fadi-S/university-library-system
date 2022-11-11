package frontend.admin;

import backend.library.database.AdminRole;
import backend.library.users.LibrarianUser;
import frontend.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;

public class ViewLibrarian implements Page {
    private JPanel panel;

    private final JFrame frame;

    public ViewLibrarian(AdminRole role) {
        frame = new JFrame("View Librarians");

        String[] columns = {"Librarian ID", "Name", "Email", "Address", "Phone Number"};
        frame.setContentPane(panel);

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
        table.setUI(new BasicTableUI());

        table.setBounds(30, 40, 200, 300);
        frame.add(new JScrollPane(table));

    }

    public JFrame getFrame() {
        return frame;
    }
}
