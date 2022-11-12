package frontend;

import constant.LoginCredentials;

public class AdminLogin extends Login {
    public AdminLogin() {
        getjFrame().setTitle("Admin login");

        name = LoginCredentials.ADMIN_USERNAME;
        password = LoginCredentials.ADMIN_PASSWORD;
    }

    @Override
    Page nextPage() {
        return new AdminRole();
    }
}
