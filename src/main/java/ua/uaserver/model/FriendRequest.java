package ua.uaserver.model;

public class FriendRequest {
    private final String email;
    private final String personalEmail;

    public FriendRequest(String email, String personalEmail) {
        this.email = email;
        this.personalEmail = personalEmail;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }
}
