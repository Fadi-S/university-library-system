package library.utils;

import library.database.Savable;

public class Book implements Savable {
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    private String bookId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0) quantity = 0;

        this.quantity = quantity;
    }

    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    @Override
    public String getSearchKey() {
        return getBookId();
    }

    @Override
    public String serialize() {
        return lineRepresentation();
    }

    public Book(String id, String title, String authorName, String publisherName, int quantity) {
        setBookId(id);
        setTitle(title);
        setAuthorName(authorName);
        setPublisherName(publisherName);
        setQuantity(quantity);
    }

    public boolean isOutOfStock()
    {
        return getQuantity() == 0;
    }

    public void decrement()
    {
        setQuantity(getQuantity() - 1);
    }

    public void increment()
    {
        setQuantity(getQuantity() + 1);
    }

    public String lineRepresentation() {
        return getBookId() + "," + getTitle() + "," + getAuthorName() + "," + getPublisherName() + "," + getQuantity();
    }

    public static Book deserialize(String line)
    {
        String[] data = line.split(",");

        return new Book(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
    }
}
