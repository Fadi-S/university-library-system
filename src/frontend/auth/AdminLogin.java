package frontend.auth;

import constant.LoginCredentials;
import frontend.AdminRole;
import frontend.Navigator;

public class AdminLogin extends Login {
    public AdminLogin() {
        super();
        setTitle("Admin login");

        name = LoginCredentials.ADMIN_USERNAME;
        password = LoginCredentials.ADMIN_PASSWORD;
    }

    @Override
    void login() {
        Navigator.goTo(new AdminRole());
    }
}
