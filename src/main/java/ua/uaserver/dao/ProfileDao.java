package ua.uaserver.dao;

import ua.uaserver.model.*;

public interface ProfileDao {
    int addAccount(String firstname, String lastname, String birthday, double phone, String email, String password, String address);
    Profile signIn(String email, String password);
    int addNotification(FriendRequest friendRequest);
    int acceptFriendRequest(FriendRequest friendRequest);
    Notifications getNotifications(String email);
    RequestCardsList getRequestCardsList(String text);
    FriendsList getFriendList(String email);
    int notificationSeen(Notification notification, String email);
    int sendReceiveMsg(String text, String sentEmail, String receivedEmail);
    Chat getChat(String email, String friendEmail);
}
