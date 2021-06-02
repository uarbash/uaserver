package ua.uaserver.model;

import java.util.ArrayList;
import java.util.List;

public class RequestCardsList {
    public List<RequestCard> requestCardList = new ArrayList<RequestCard>();

    public List<RequestCard> getRequestCardList() {
        return requestCardList;
    }
    public void addCard(RequestCard requestCard){
        requestCardList.add(requestCard);
    }
}
