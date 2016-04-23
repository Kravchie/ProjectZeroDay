package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.HashMap;

/**
 * Created by Klaudia on 2016-04-12.
 */


public class Table  {

    private Deck deck;
    private HashMap orderedPlayers;
    private int roundCounter;

    public Table() {
        this.deck = new Deck();
        this.orderedPlayers = new HashMap();
        this.roundCounter = 1;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public HashMap getOrderedPlayers() {
        return orderedPlayers;
    }

    public void setOrderedPlayers(String uniqName, int ind) {
        this.orderedPlayers.put(uniqName, ind);
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

    public void deleteOrderedPlayer(String uniqName) {
        this.orderedPlayers.remove(uniqName);
    }

    public Card getDeckCard() {
        return deck.get_card();
    }
}
