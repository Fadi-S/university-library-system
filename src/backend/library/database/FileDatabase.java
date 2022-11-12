package backend.library.database;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

abstract class FileDatabase {
    private final String filname;
    private ArrayList<Item> records;

    FileDatabase(String filename) {
        this.filname = filename;
        readFromFile();
    }

    abstract public Item createRecordFrom(String line);

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

    public ArrayList<Item> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        return getRecord(key) != null;
    }

    public Item getRecord(String key) {
        Optional<Item> optionalSavable = records.stream().filter(
                savable -> savable.getSearchKey().equalsIgnoreCase(key)
        ).findFirst();

        return optionalSavable.orElse(null);
    }

    public void insertRecord(Item record) {
        deleteRecord(record.getSearchKey());

        records.add(record);
    }

    public void deleteRecord(String key) {
        records.removeIf((savable) -> savable.getSearchKey().equalsIgnoreCase(key));
    }

    public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFile()));
            for (Item item : records) {
                writer.write(item.lineRepresentation() + "\n");
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
