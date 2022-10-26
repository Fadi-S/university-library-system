package library.database;

public class StudentBookBasicDatabase extends BasicDatabase {
    public StudentBookBasicDatabase(String filename) {
        super(filename);
    }

    @Override
    public Savable createRecordFrom(String line) {
        return null;
    }
}
