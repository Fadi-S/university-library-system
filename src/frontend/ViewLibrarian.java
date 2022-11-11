package frontend;

import backend.library.users.LibrarianUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewLibrarian extends JFrame implements Node {
    private final String[] colomnsName;
    private JPanel panel5;
    private JTable table1;
    Node parent;
    String[][] data;

    public ViewLibrarian(){
        this.colomnsName=new String[]{"id","name","email","address","phone number"};
        setContentPane(panel5);
        setTitle("View Librarian");
        setSize(450,300);
        setVisible(true);
        backend.library.users.AdminRole adminRole= new backend.library.users.AdminRole();
        LibrarianUser[] librarian= adminRole.getListOfLibrarians();
        String[][] data=new String[librarian.length][5];
        for (int i = 0; i <librarian.length ; i++) {
            data[i][0]=librarian[i].getId();
            data[i][1]=librarian[i].getName();
            data[i][2]=librarian[i].getEmail();
            data[i][3]=librarian[i].getAddress();
            data[i][4]=librarian[i].getPhoneNumber();
        }
        table1.setModel(new DefaultTableModel(data,colomnsName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        }

    @Override
    public void setParentNode(Node n) {
        this.parent=n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
