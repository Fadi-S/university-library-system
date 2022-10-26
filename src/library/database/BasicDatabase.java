package library.database;

import java.util.ArrayList;

public abstract class BasicDatabase implements Database {
    protected final String filname;
    protected ArrayList<Savable> records;

    public BasicDatabase(String filename) {
        this.filname = filename;
    }

    abstract public Savable createRecordFrom(String line);

    @Override
    public void readFromFile() {

    }

    @Override
    public ArrayList<Savable> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Savable getRecord(String key) {
        return null;
    }

    @Override
    public void insertRecord(Savable record) {

    }

    @Override
    public void deleteRecord(String key) {

    }

    @Override
    public void saveToFile() {

    }
}
