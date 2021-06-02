package ua.uaserver.model;

import java.util.ArrayList;
import java.util.List;

public class FriendsList {
    private List<FriendCard> friendList = new ArrayList<FriendCard>();
    private Chat chat;

    public FriendsList() {
        this.chat = new Chat();
    }

    public List<FriendCard> getFriendsList() {
        return friendList;
    }
    public void addFriend(FriendCard friendCard){
        this.friendList.add(friendCard);
    }

    public Chat getChat() {
        return chat;
    }
}
