package frontend.auth;

import constant.LoginCredentials;
import frontend.AdminRole;
import frontend.Page;

public class AdminLogin extends Login {
    public AdminLogin() {
        getFrame().setTitle("Admin login");

        name = LoginCredentials.ADMIN_USERNAME;
        password = LoginCredentials.ADMIN_PASSWORD;
    }

    @Override
    Page nextPage() {
        return new AdminRole();
    }
}
