package com.crazysquirrelsofdestruction.zeroday.model;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Player {

    private Card[] cards;
    private int points;
    private String uniqName;
    private int inQueue;
    private int chosenCard;
    private Boolean initState;

    public Player(String uniqName){
        this.uniqName = uniqName;
        this.inQueue = inQueue;
        cards = new Card[2];
        points = 0;
        initState = false;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getUniqName() {
        return uniqName;
    }

    public void setUniqName(String uniqName) {
        this.uniqName = uniqName;
    }

    public int getInQueue() {
        return inQueue;
    }

    public void setInQueue(int inQueue) {
        this.inQueue = inQueue;
    }

    public void setCard(Card card) {
        if(cards[0] == null){
            cards[0] = card;
        }
        else if(cards[1] == null){
            cards[1] = card;
        }
        initState = true;
    }

    public int getChosenCard() {
        return chosenCard;
    }

    public void setChosenCard(int chosenCard) {
        this.chosenCard = chosenCard;
    }

    public Boolean getInitState() {
        return initState;
    }

    public void setInitState(Boolean initState) {
        this.initState = initState;
    }
}
