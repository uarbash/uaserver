package ua.uaserver.IOController;


import org.springframework.web.bind.annotation.*;
import ua.uaserver.model.*;
import ua.uaserver.services.ProfileService;

@RequestMapping("api/v1/ua")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(path="signup")
    public int signup(@RequestBody Profile profile){
        return this.profileService.addAccount(profile.getFirstname(), profile.getLastname(), profile.getEmail(),
                profile.getPhone(), profile.getPassword(), profile.getAddress(), profile.getBirthday());
    }

    @PostMapping(path="signin")
    public Profile signin(@RequestBody ProfileSignIn profileSignIn){
        Profile account = this.profileService.signIn(profileSignIn.getEmail(), profileSignIn.getPassword());
        Profile copyAccount = new Profile(account.getEmail(), account.getPassword(), account.getFirstname(),
                account.getLastname(), account.getBirthday(), account.getPhone(),
                account.getAddress(), account.getNotifications(), account.getFriendsList());
        copyAccount.setPassword("********");
        return copyAccount;
    }

    @PutMapping(path = "contacts", params = "sendRequest")
    public int addNotification(@RequestBody FriendRequest friendRequest){
        return this.profileService.addNotifications(friendRequest);
    }

    @PutMapping(path="profile", params = "notification_seen")
    public int notificationSeen(@RequestBody Notification notification, @RequestParam String notification_seen){
     return this.profileService.notificationSeen(notification, notification_seen);
    }

    @PostMapping(path = "profile", params = "acceptRequest")
    public int addFriend(@RequestBody FriendRequest friendRequest){
        return this.profileService.acceptRequest(friendRequest);
    }

    @PostMapping(path ="profile", params = "notifications")
    public Notifications getNotification(@RequestBody String email){
        return this.profileService.getNotifications(email);
    }
    @PostMapping("contacts")
    public RequestCardsList getRequestCardsList(@RequestBody String text){
        return this.profileService.getRequestCardsList(text);
    }
    @GetMapping(path = "contacts/friends-list", params = "email")
    public FriendsList getFriendsList(@RequestParam String email){
        return this.profileService.getFriendsList(email);
    }

    @PutMapping(path="contacts", params = "chat")
    public int sendReceiveMsg(@RequestBody MsgModel msg){
        return this.profileService.sendReceiveMsg(msg.getText(), msg.getSentEmail(), msg.getReceivedEmail());
    }
    @GetMapping(path = "contacts/chat/{email}/{friendEmail}")
    public Chat getChat(@PathVariable("email") String email, @PathVariable("friendEmail") String friendEmail){
        return this.profileService.getChat(email, friendEmail);
    }
}
