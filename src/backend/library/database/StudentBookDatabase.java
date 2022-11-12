package backend.library.database;

import backend.library.StudentBook;

class StudentBookDatabase extends FileDatabase {
    StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public StudentBook createRecordFrom(String line) {
        return StudentBook.createFromString(line);
    }
}
