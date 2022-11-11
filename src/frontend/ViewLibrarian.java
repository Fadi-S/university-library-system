package frontend;

import backend.library.users.LibrarianUser;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;

public class ViewLibrarian implements Page {
    private JPanel panel5;
    private final JTable table1;

    private JFrame frame;

    public ViewLibrarian() {
        frame = new JFrame("View Librarians");

        String[] columns = {"id", "name", "email", "address", "phone number"};
        frame.setContentPane(panel5);

        backend.library.users.AdminRole adminRole = new backend.library.users.AdminRole();
        LibrarianUser[] librarian = adminRole.getListOfLibrarians();
        String[][] data = new String[librarian.length][5];
        for (int i = 0; i < librarian.length; i++) {
            data[i][0] = librarian[i].getId();
            data[i][1] = librarian[i].getName();
            data[i][2] = librarian[i].getEmail();
            data[i][3] = librarian[i].getAddress();
            data[i][4] = librarian[i].getPhoneNumber();
        }
        table1=new JTable(data,columns){@Override
            public boolean isCellEditable(int row, int column) {return false;}
        };
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setUI(new BasicTableUI());
        table1.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table1);
        frame.add(sp);

    }

    public JFrame getFrame() {
        return frame;
    }
}
