package ua.uaserver.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Msg> chat = new ArrayList<Msg>();

    public List<Msg> getChat() {
        return chat;
    }
    public void addMsg(Msg msg){
        this.chat.add(msg);
    }
}
