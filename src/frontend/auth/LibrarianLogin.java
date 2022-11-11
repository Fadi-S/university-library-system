package frontend.auth;

import frontend.librarian.LibrarianRole;
import constant.LoginCredentials;

public class LibrarianLogin extends Login {
    public LibrarianLogin() {
        super();

        name = LoginCredentials.LIBRARIAN_USERNAME;
        password = LoginCredentials.LIBRARIAN_PASSWORD;
    }

    @Override
    void login() {
        new LibrarianRole();
    }
}
