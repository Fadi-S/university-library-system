package backend.library.database;

import backend.library.utils.Book;

public class BookDatabase extends FileDatabase {
    public BookDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return Book.deserialize(line);
    }
}