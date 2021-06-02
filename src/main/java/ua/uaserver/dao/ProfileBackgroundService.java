package ua.uaserver.dao;

import org.springframework.stereotype.Repository;
import ua.uaserver.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository("profileBackgroundService")
public class ProfileBackgroundService implements ProfileDao{
    private static List<Profile> DB = new ArrayList<Profile>();
    @Override
    public int addAccount(String firstname, String lastname, String birthday, double phone, String email, String password, String address) {
        if(this.checkForEmailInDB(email)){
            return 1;
        }
        else{
            DB.add(new Profile(email, password, firstname, lastname, birthday, phone, address,
                    new Notifications(), new FriendsList()));
            return 0;
        }
    }

    @Override
    public Profile signIn(String email, String password) {
        if(this.checkForEmailInDB(email)){
            Profile userAccount = this.getProfile(email);
            if(userAccount.getPassword().equals(password)){
                return userAccount;
            }
        }
        return new Profile("INVALID","INVALID","INVALID",
                "INVALID","INVALID",0,"INVALID", new Notifications(), new FriendsList());
    }

    @Override
    public int addNotification(FriendRequest friendRequest) {
        if (this.checkForEmailInDB(friendRequest.getEmail())){
           Profile friendAccount = this.getProfile(friendRequest.getEmail());
           Profile personalAccount = this.getProfile(friendRequest.getPersonalEmail());
           if(!friendAccount.getNotifications().notifications.stream()
                   .anyMatch(notification -> notification.getEmail().equals(personalAccount.getEmail()))){
               friendAccount.getNotifications()
                       .addNotification(new Notification(personalAccount.getFirstname(),
                               personalAccount.getLastname(), friendRequest.getPersonalEmail(), true));
           }
           return 0;
        }
        return 1;
    }

    @Override
    public int acceptFriendRequest(FriendRequest friendRequest) {
        if(this.checkForEmailInDB(friendRequest.getEmail())){
            if(this.getProfile(friendRequest.getPersonalEmail()).getFriendsList().getFriendsList().stream().noneMatch(friend -> friend.getEmail().equals(friendRequest.getEmail()))){
                Profile personal = this.getProfile(friendRequest.getPersonalEmail());
                Profile friend = this.getProfile(friendRequest.getEmail());
                FriendCard friendCard = new FriendCard(friend.getFirstname(), friend.getLastname(),
                        friend.getBirthday(), friend.getAddress(),
                        friend.getPhone(), friend.getEmail());
                FriendCard personalFriendCard = new FriendCard(personal.getFirstname(), personal.getLastname(), personal.getBirthday(),
                        personal.getAddress(), personal.getPhone(), personal.getEmail());
                personal.getFriendsList().addFriend(friendCard);
                friend.getFriendsList().addFriend(personalFriendCard);
                Notification notificationToDelete = friend.getNotifications().notifications.stream()
                        .filter(notification -> notification.getEmail().equals(personal.getEmail())).findFirst().get();
                friend.getNotifications().notifications.remove(notificationToDelete);
                return 0;
            }
            return 1;
        }
        return 1;
    }

    @Override
    public Notifications getNotifications(String email) {
        if(DB.stream().anyMatch(account -> account.getEmail().equals(email))){
            return DB.stream().filter(account -> account.getEmail().equals(email)).findFirst().get().getNotifications();
        }
        return null;
    }

    @Override
    public RequestCardsList getRequestCardsList(String text) {
        RequestCardsList requestCardsList = new RequestCardsList();
        DB.stream().forEach(account -> {
            if(account.getEmail().toLowerCase().startsWith(text.toLowerCase())){
                requestCardsList.addCard(new RequestCard(account.getEmail(), account.getFirstname(), account.getLastname()));
            }
        });
        return requestCardsList;
    }

    @Override
    public FriendsList getFriendList(String email) {
        if(this.checkForEmailInDB(email)){
            return this.getProfile(email).getFriendsList();
        }
        return null;
    }
    public boolean checkForEmailInDB(String email){
        return DB.stream().anyMatch(account -> account.getEmail().equals(email));
    }
    public Profile getProfile(String email){
        return DB.stream().filter(account -> account.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public int notificationSeen(Notification notificationCard, String email){
        Notifications notifications = this.getNotifications(email);
        notifications.notifications.stream().filter(notification -> notification.getEmail().equals(notificationCard.getEmail())).findFirst().get().setNewNotification(false);
        return 0;
    }

    @Override
    public int sendReceiveMsg(String text, String sentEmail, String receivedEmail){
        System.out.println(receivedEmail);
        this.getProfile(sentEmail).getFriendsList().getFriendsList().stream()
                .filter(card -> card.getEmail().equals(receivedEmail)).findFirst().get().getChat().getChat().add(new Msg(text, true));
        this.getProfile(receivedEmail).getFriendsList().getFriendsList().stream()
                .filter(card -> card.getEmail().equals(sentEmail)).findFirst().get().getChat().getChat().add(new Msg(text, false));
        return 0;
    }

    @Override
    public Chat getChat(String email, String friendEmail){
        System.out.print(email);
        System.out.print(friendEmail);
        return this.getProfile(email).getFriendsList().getFriendsList().stream()
                .filter(card -> card.getEmail().equals(friendEmail)).findFirst().get().getChat();
    }
}
