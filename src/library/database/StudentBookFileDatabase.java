package library.database;

import library.utils.StudentBook;

public class StudentBookFileDatabase extends FileDatabase {
    public StudentBookFileDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return StudentBook.deserialize(line);
    }
}
