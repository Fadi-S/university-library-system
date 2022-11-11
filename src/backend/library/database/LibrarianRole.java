package backend.library.database;

import backend.library.database.BookDatabase;
import backend.library.database.FileDatabase;
import backend.library.database.StudentBookDatabase;
import backend.library.utils.Book;
import backend.library.utils.StudentBook;
import constant.FileNames;

import java.time.LocalDate;

public class LibrarianRole implements FileNames {
    BookDatabase booksDatabase;
    StudentBookDatabase sBDatabase;

    public LibrarianRole()
    {
        booksDatabase = new BookDatabase(FileNames.BOOKS_FILENAME);

        sBDatabase = new StudentBookDatabase(FileNames.STUDENTSBOOKS_FILENAME);
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
        booksDatabase.addRecordToFile(new Book(id, title, authorName, publisherName, quantity));
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate)
    {
        Book book = (Book) booksDatabase.getRecord(bookId);
        StudentBook studentBook = new StudentBook(studentId, bookId, borrowDate);

        if(book == null || book.isOutOfStock()) {
            return 0;
        }

        if(sBDatabase.contains(studentBook.getSearchKey())) {
            return 1;
        }

        sBDatabase.addRecordToFile(studentBook);

        book.decrement();
        booksDatabase.insertRecord(book);
        booksDatabase.saveToFile();

        return 2;
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate)
    {
        StudentBook studentBook = new StudentBook(studentId, bookId, null);

        studentBook = (StudentBook) sBDatabase.getRecord(studentBook.getSearchKey());
        if(studentBook == null) {
            return 0;
        }

        Book book = (Book) booksDatabase.getRecord(bookId);

        double lateFee = calculateLateFee(studentBook, returnDate);
        sBDatabase.deleteRecord(studentBook.getSearchKey());
        sBDatabase.saveToFile();

        book.increment();
        booksDatabase.addRecordToFile(book);

        return lateFee;
    }

    private double calculateLateFee(StudentBook studentBook, LocalDate returnDate)
    {
        long diffDays = returnDate.toEpochDay() - studentBook.getBorrowDate().toEpochDay();

        if(diffDays <= 7) {
            return 0;
        }

        return (diffDays - 7) * 0.5;
    }

    public StudentBook[] getListOfBorrowingOperations()
    {
        return sBDatabase.returnAllRecords().toArray(new StudentBook[0]);
    }

    public Book[] getListOfBooks()
    {
        return booksDatabase.returnAllRecords().toArray(new Book[0]);
    }

    public void logout()
    {
        booksDatabase.saveToFile();

        sBDatabase.saveToFile();
    }
}
