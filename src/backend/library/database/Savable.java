package backend.library.database;

public interface Savable {
    String getSearchKey();

    String serialize();
}
