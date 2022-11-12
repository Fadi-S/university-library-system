package backend.library.database;

import backend.library.utils.Book;

class BookDatabase extends FileDatabase {
    BookDatabase(String filename) {
        super(filename);
    }

    @Override
    public Item createRecordFrom(String line) {
        return Book.createFromString(line);
    }
}
