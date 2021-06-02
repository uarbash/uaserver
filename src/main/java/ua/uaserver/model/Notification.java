package ua.uaserver.model;

public class Notification {
    private final String firstname;
    private final String lastname;
    private final String email;
    private boolean newNotification;

    public Notification(String firstname, String lastname, String email, boolean newNotification) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.newNotification = newNotification;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNewNotification() {
        return newNotification;
    }

    public void setNewNotification(boolean newNotification) {
        this.newNotification = newNotification;
    }
}
