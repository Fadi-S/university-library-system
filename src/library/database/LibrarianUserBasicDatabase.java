package library.database;

public class LibrarianUserBasicDatabase extends BasicDatabase {
    public LibrarianUserBasicDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return null;
    }
}
