package backend.library.database;

import backend.library.LibrarianUser;

class LibrarianUserDatabase extends FileDatabase {
    LibrarianUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public LibrarianUser createRecordFrom(String line) {
        return LibrarianUser.createFromString(line);
    }
}
