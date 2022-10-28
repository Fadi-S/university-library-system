package library.utils;

import library.database.Savable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentBook implements Savable {

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private String studentId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    private String bookId;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.setStudentId(studentId);
        this.setBookId(bookId);
        this.setBorrowDate(borrowDate);
    }

    @Override
    public String getSearchKey() {
        return getStudentId() + "," + getBookId();
    }

    @Override
    public String serialize() {
        return lineRepresentation();
    }

    public String lineRepresentation() {
        return getStudentId() + "," + getBookId() + "," + getBorrowDate().format(DateTimeFormatter.ISO_DATE);
    }

    public static StudentBook deserialize(String line)
    {
        String[] data = line.split(",");

        LocalDate date = LocalDate.parse(data[2]);

        return new StudentBook(data[0], data[1], date);
    }
}
