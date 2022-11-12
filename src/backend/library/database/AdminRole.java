package backend.library.database;
import backend.library.LibrarianUser;
import constant.FileNames;

public class AdminRole implements FileNames {

    private LibrarianUserDatabase database;

    public AdminRole()
    {
        database = new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);
    }
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber)
    {
        database.insertRecord(new LibrarianUser(librarianId, name, email, address, phoneNumber));
    }

    public void removeLibrarian(String key) {
        database.deleteRecord(key);
    }

    public LibrarianUser[] getListOfLibrarians()
    {
        return database.returnAllRecords().toArray(new LibrarianUser[0]);
    }

    public void logout() {
        database.saveToFile();
    }
}
