package ua.uaserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.uaserver.dao.ProfileBackgroundService;
import ua.uaserver.model.*;


@Service
public class ProfileService {
    private ProfileBackgroundService profileBackgroundService;
    @Autowired
    public ProfileService(@Qualifier("profileBackgroundService") ProfileBackgroundService profileBackgroundService) {
        this.profileBackgroundService = profileBackgroundService;
    }

    public int addAccount(String firstname, String lastname, String email, double phone, String password, String address, String birthday){
       return this.profileBackgroundService.addAccount(firstname, lastname, birthday, phone, email, password, address);
    }
    public Profile signIn(String email, String password){
        return this.profileBackgroundService.signIn(email, password);
    }
    public int addNotifications(FriendRequest friendRequest){
        return this.profileBackgroundService.addNotification(friendRequest);
    }
    public int acceptRequest(FriendRequest friendRequest){
        return this.profileBackgroundService.acceptFriendRequest(friendRequest);
    }

    public Notifications getNotifications(String email){
        return this.profileBackgroundService.getNotifications(email);
    }
    public RequestCardsList getRequestCardsList(String text){
        return this.profileBackgroundService.getRequestCardsList(text);
    }
    public FriendsList getFriendsList(String email){
        return this.profileBackgroundService.getFriendList(email);
    }

    public int notificationSeen(Notification notification, String email){
        return this.profileBackgroundService.notificationSeen(notification, email);
    }
    public int sendReceiveMsg(String text, String sentEmail, String receivedEmail){
        return this.profileBackgroundService.sendReceiveMsg(text, sentEmail, receivedEmail);
    }
    public Chat getChat(String email, String friendEmail){
        return this.profileBackgroundService.getChat(email, friendEmail);
    }
}
