package library.database;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public abstract class FileDatabase implements Database {
    private final String filname;
    private ArrayList<Savable> records;

    public FileDatabase(String filename) {
        this.filname = filename;

        records = new ArrayList<>();
    }

    abstract public Savable createRecordFrom(String line);

    @Override
    public void readFromFile() {
        Scanner scanner;
        try {
            scanner = new Scanner(getFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            records.add(createRecordFrom(scanner.nextLine()));
        }
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
                (Savable savable) -> savable.getSearchKey().equalsIgnoreCase(key)
        ).findFirst();

        return optionalSavable.orElse(null);
    }

    @Override
    public void insertRecord(Savable record) {
        records.add(record);
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
