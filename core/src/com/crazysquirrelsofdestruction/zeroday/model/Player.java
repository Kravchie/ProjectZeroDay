package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.HashMap;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Player {

    private Card[] cards;
    private int points;
    private String uniqName;
    private int inQueue;
    private int chosenCard;

    public Player(String uniqName){
        this.uniqName = uniqName;
        this.inQueue = inQueue;
        cards = new Card[2];
        points = 0;
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

    public void withdraw(Deck deck){
        if(cards[0] == null){
            cards[0] = deck.get_card();
        }
        else if(cards[1] == null){
            cards[1] = deck.get_card();
        }
    }

    public int getChosenCard() {
        return chosenCard;
    }

    public void setChosenCard(int chosenCard) {
        this.chosenCard = chosenCard;
    }
}
