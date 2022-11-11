package frontend.auth;

import frontend.Page;
import frontend.librarian.LibrarianRole;
import constant.LoginCredentials;

public class LibrarianLogin extends Login {
    public LibrarianLogin() {
        getFrame().setTitle("Librarian Login");

        name = LoginCredentials.LIBRARIAN_USERNAME;
        password = LoginCredentials.LIBRARIAN_PASSWORD;
    }

    @Override
    Page nextPage() {
        return new LibrarianRole();
    }
}
