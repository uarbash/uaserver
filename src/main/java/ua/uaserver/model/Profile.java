package ua.uaserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {
    private final String email;
    private String password;
    private final String firstname;
    private final String lastname;
    private final String birthday;
    private double phone;
    private String address;
    private final Notifications notifications;
    private FriendsList friendsList;

    public Profile(@JsonProperty("email") String email,@JsonProperty("password") String password,
                   @JsonProperty("firstname") String firstname,@JsonProperty("lastname") String lastname,
                   @JsonProperty("birthday")String birthday,@JsonProperty("phone") double phone,
                   @JsonProperty("address") String address, Notifications notifications, FriendsList friendsList) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.notifications = notifications;
        this.friendsList = friendsList;
    }

    public FriendsList getFriendsList() {
        return friendsList;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public double getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
