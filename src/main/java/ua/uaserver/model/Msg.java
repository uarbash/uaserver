package ua.uaserver.model;

public class Msg {
    private final String text;
    private final boolean iSent;

    public Msg(String text, boolean iSent) {
        this.text = text;
        this.iSent = iSent;
    }

    public String getText() {
        return text;
    }

    public boolean isiSent() {
        return iSent;
    }
}
