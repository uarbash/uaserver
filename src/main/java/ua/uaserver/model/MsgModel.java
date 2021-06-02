package ua.uaserver.model;

public class MsgModel {
    private final String text;
    private final String sentEmail;
    private final String receivedEmail;

    public MsgModel(String text, String sentEmail, String receivedEmail) {
        this.text = text;
        this.sentEmail = sentEmail;
        this.receivedEmail = receivedEmail;
    }

    public String getText() {
        return text;
    }

    public String getSentEmail() {
        return sentEmail;
    }

    public String getReceivedEmail() {
        return receivedEmail;
    }
}
