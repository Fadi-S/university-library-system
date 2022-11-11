package frontend.utils;

import backend.library.database.Savable;

public class SearchSavables {
    public static Savable handle(Savable[] items, String id) {
        for (Savable savable : items) {
            if (id.equals(savable.getSearchKey()))
                return savable;
        }
        return null;
    }
}
