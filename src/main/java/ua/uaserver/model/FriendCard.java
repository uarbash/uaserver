package ua.uaserver.model;

public class FriendCard {
    private final String firstname;
    private final String lastname;
    private final String birthday;
    private final String address;
    private final double phone;
    private final String email;
    private Chat chat;

    public FriendCard(String firstname, String lastname, String birthday, String address, double phone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.chat = new Chat();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public double getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public Chat getChat() {
        return chat;
    }
}
