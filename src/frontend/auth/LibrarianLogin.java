package frontend.auth;

import constant.LoginCredentials;
import frontend.Node;

public class LibrarianLogin extends Login implements Node {
    private Node parent;

    public LibrarianLogin() {
        setTitle("Librarian login");

        name = LoginCredentials.LIBRARIAN_USERNAME;
        password = LoginCredentials.LIBRARIAN_PASSWORD;
    }

    @Override
    void login() {
        // TODO redirect to librarian role frontend
    }

    @Override
    public void setParentNode(Node n) {
        this.parent = n;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
