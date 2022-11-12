package backend.library.database;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

abstract class FileDatabase implements Database {
    private final String filname;
    private ArrayList<Savable> records;

    FileDatabase(String filename) {
        this.filname = filename;
        readFromFile();
    }

    abstract public Savable createRecordFrom(String line);

    @Override
    public void readFromFile() {
        records = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(getFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            records.add(createRecordFrom(scanner.nextLine()));
        }

        scanner.close();
    }

    @Override
    public ArrayList<Savable> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        return getRecord(key) != null;
    }

    @Override
    public Savable getRecord(String key) {
        Optional<Savable> optionalSavable = records.stream().filter(
                savable -> savable.getSearchKey().equalsIgnoreCase(key)
        ).findFirst();

        return optionalSavable.orElse(null);
    }

    @Override
    public void insertRecord(Savable record) {
        deleteRecord(record.getSearchKey());

        records.add(record);
    }

    public void addRecordToFile(Savable record) {
        insertRecord(record);
    }

    @Override
    public void deleteRecord(String key) {
        records.removeIf((savable) -> savable.getSearchKey().equalsIgnoreCase(key));
    }

    @Override
    public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFile()));
            for (Savable savable : records) {
                writer.write(savable.serialize());
                writer.newLine();
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getFile()
    {
        try {
            File file = new File(this.filname);

            file.createNewFile();

            return file;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
