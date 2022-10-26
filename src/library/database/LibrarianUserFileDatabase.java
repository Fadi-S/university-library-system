package library.database;

import library.users.LibrarianUser;

public class LibrarianUserFileDatabase extends FileDatabase {
    public LibrarianUserFileDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return LibrarianUser.deserialize(line);
    }
}
