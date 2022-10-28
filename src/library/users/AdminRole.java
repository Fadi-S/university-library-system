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
        return database.returnAllRecords().toArray(new LibrarianUser[0]);
    }

    public void logout() {
        database.saveToFile();
    }
}
