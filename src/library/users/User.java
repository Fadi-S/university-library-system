package library.users;

import library.database.Savable;

public abstract class User implements Savable {
    @Override
    public String getSearchKey() {
        return null;
    }

    @Override
    public String serialize() {
        return null;
    }
}
