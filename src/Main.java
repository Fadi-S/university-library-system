import backend.library.database.AdminRole;
import backend.library.database.LibrarianRole;
import backend.library.users.LibrarianUser;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        LibrarianRole librarian = new LibrarianRole();

        AdminRole admin = new AdminRole();

        librarian.addBook("B100", "Clean Code", "Robert Cecil Martin", "Test", 5);
        librarian.addBook("B101", "Code Complete", "Steve McConnell", "Test 2", 7);
        librarian.addBook("B150", "Code: The Hidden Language of Computer Hardware and Software", "Charles Petzold", "Test 3", 3);
        librarian.addBook("B155", "SOLID principles", "Fadi Sarwat", "Test 3", 3);
        librarian.addBook("B700", "Easter Eggs are funny", "Fadi Sarwat", "Test 2", 6);
        librarian.addBook("B704", "Book of laravel", "Taylor Otwell", "Test 2", 6);

        admin.addLibrarian("L7432", "Fadi", "me@fadisarwat.dev", "Alexandria", "01273315870");
        admin.addLibrarian("L7406", "Peter", "peto4anton@gmail.com", "Alexandria", "01228044609");
        admin.addLibrarian("L7621", "Zeyad", "zeyadmokled@hotmail.com", "Alexandria", "01017770318");

        admin.addLibrarian("L7652", "7ad msh 7a2i2i", "7admsh7a2i2i@hotmail.com", "Alexandria", "01234567898");

        for (LibrarianUser user : admin.getListOfLibrarians()) {
            user.print();
        }
        System.out.println();
        admin.removeLibrarian("L7652");

        for (LibrarianUser user : admin.getListOfLibrarians()) {
            user.print();
        }

        System.out.println();

        System.out.println("Borrow book");
        if(librarian.borrowBook("7432", "B100", LocalDate.now()) == 2) {
            System.out.println("Success");
        }

        System.out.println("Borrowing same book twice: ");
        if(librarian.borrowBook("7432", "B100", LocalDate.now()) == 1){
            System.out.println("You already have this book");
        }

        System.out.println("Borrow another book:");
        if(librarian.borrowBook("7406", "B150", LocalDate.now()) == 2) {
            System.out.println("Success");
        }

        System.out.println();

        System.out.println("Return book 1 9 days later");
        double lateFee = librarian.returnBook("7432", "B100", LocalDate.now().plusDays(9));
        System.out.println("Book returned with fee: " + lateFee);


        System.out.println("Borrowing a book that doesn't exist");
        if(librarian.borrowBook("7432", "fdfs", LocalDate.now()) == 0) {
            System.out.println("Book does not exist");
        }

        librarian.returnBook("7406", "B150", LocalDate.now());

        System.out.println();
        System.out.println("Borrow book more than available quantity");
        librarian.borrowBook("7406", "B155", LocalDate.now());
        librarian.borrowBook("7432", "B155", LocalDate.now());
        librarian.borrowBook("7621", "B155", LocalDate.now());

        if(librarian.borrowBook("7777", "B155", LocalDate.now()) == 0) {
            System.out.println("Book out of stock");
        }
        System.out.println("Try again after books have been returned: ");

        librarian.returnBook("7406", "B155", LocalDate.now());
        librarian.returnBook("7432", "B155", LocalDate.now());
        librarian.returnBook("7621", "B155", LocalDate.now());

        if(librarian.borrowBook("7777", "B155", LocalDate.now()) == 2) {
            System.out.println("Book burrowed successfully");
        }

        librarian.returnBook("7777", "B155", LocalDate.now());

        librarian.logout();
        admin.logout();
    }
}
