package frontend;

import constant.LoginCredentials;

public class LibrarianLogin extends Login {
    public LibrarianLogin() {
        getjFrame().setTitle("Librarian Login");

        name = LoginCredentials.LIBRARIAN_USERNAME;
        password = LoginCredentials.LIBRARIAN_PASSWORD;
    }

    @Override
    Page nextPage() {
        return new LibrarianRole();
    }
}
