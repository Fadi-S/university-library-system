package backend.library.database;

import backend.library.users.LibrarianUser;

public class LibrarianUserDatabase extends FileDatabase {
    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public LibrarianUser createRecordFrom(String line) {
        return LibrarianUser.deserialize(line);
    }
}
