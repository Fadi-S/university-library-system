package backend.library.database;

import backend.library.utils.StudentBook;

public class StudentBookDatabase extends FileDatabase {
    public StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public StudentBook createRecordFrom(String line) {
        return StudentBook.deserialize(line);
    }
}
