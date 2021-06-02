package ua.uaserver.model;

public class ProfileSignIn {
    private final String email;
    private final String password;

    public ProfileSignIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
