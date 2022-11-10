package library.users;

import library.database.LibrarianUserDatabase;

public class AdminRole {

    private LibrarianUserDatabase database;

    public AdminRole()
    {
        database = new LibrarianUserDatabase("Librarians.txt");
    }
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber)
    {
        database.addRecordToFile(new LibrarianUser(librarianId, name, email, address, phoneNumber));
    }

    public void removeLibrarian(String key) {
        database.deleteRecord(key);

        database.saveToFile();
    }

    public LibrarianUser[] getListOfLibrarians()
    {
        if(database.returnAllRecords()!= null) return (LibrarianUser[])database.returnAllRecords().toArray();
        return null;
    }

    public void logout() {
        database.saveToFile();
    }
}
