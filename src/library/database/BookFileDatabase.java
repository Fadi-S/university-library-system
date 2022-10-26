package library.database;

import library.utils.Book;

public class BookFileDatabase extends FileDatabase {
    public BookFileDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return Book.deserialize(line);
    }
}
