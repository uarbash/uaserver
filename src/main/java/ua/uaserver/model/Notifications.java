package ua.uaserver.model;

import java.util.ArrayList;
import java.util.List;

public class Notifications {
    public List<Notification> notifications = new ArrayList<Notification>();
    public int addNotification(Notification notification){
        notifications.add(notification);
        return 0;
    }
}
