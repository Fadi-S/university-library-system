package library.database;

import library.utils.StudentBook;

public class StudentBookDatabase extends FileDatabase {
    public StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return StudentBook.deserialize(line);
    }
}
