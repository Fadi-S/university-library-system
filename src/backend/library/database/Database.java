package backend.library.database;

import java.util.ArrayList;

public interface Database {
    void readFromFile();

    Savable createRecordFrom(String line);

    ArrayList<Savable> returnAllRecords();

    boolean contains(String key);

    Savable getRecord(String key);

    void insertRecord(Savable record);

    void deleteRecord(String key);

    void saveToFile();
}
