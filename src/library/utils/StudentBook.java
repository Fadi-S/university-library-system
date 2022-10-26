package library.utils;

import library.database.Savable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class StudentBook implements Savable {

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String studentId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String bookId;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate borrowDate;

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return getStudentId() + "," + getBookId() + "," + formatter.format(getBorrowDate());
    }

    public static StudentBook deserialize(String line)
    {
        String[] data = line.split(",");

        LocalDate date = LocalDate.parse(data[20]);

        return new StudentBook(data[0], data[1], date);
    }
}
