import library.users.AdminRole;
import library.users.LibrarianRole;

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
        librarian.addBook("B700", "Easter Eggs are funny", "Fadi Sarwat", "Test 2", 6);
        librarian.addBook("B700", "Easter Eggs are funny", "Fadi Sarwat", "Test 2", 6);
        librarian.addBook("B704", "Book of laravel", "Taylor Otwell", "Test 2", 6);

        admin.addLibrarian("L100", "Fadi", "me@fadisarwat.dev", "Alexandria", "01273315870");
        admin.addLibrarian("L130", "Ahmed", "ahmed@gamil.com", "Alexandria", "01273315876");


        System.out.println("Borrowing same book twice: ");
        if(librarian.borrowBook("7432", "B100", LocalDate.now()) == 2) {
            System.out.println("Success");
        }

        if(librarian.borrowBook("7432", "B100", LocalDate.now()) == 1){
            System.out.println("You already have this book");
        }

        if(librarian.borrowBook("7432", "fdfs", LocalDate.now()) == 0) {
            System.out.println("Book does not exist");
        }

        librarian.logout();

        admin.logout();
    }
}
