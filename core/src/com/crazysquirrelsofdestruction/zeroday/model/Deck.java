package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by otorr on 22/04/2016.
 */
public class Deck {
    /* deckList */
    private ArrayList<Card> deckList;

    public Deck() {
        deckList = new ArrayList<Card>();
        initDeck();
    }

    public int getDeckSize(){
        return deckList.size();
    }

    public void initDeck() {
        /* Start:
            1 x Big Fish card
            2 x White hat card
            2 x Black hat card
            3 x Cracker card
            4 x Skiddie card
         */
        deckList.clear();
        deckList.add(new Card(Card.TYPE_BIGFISH,0));

        deckList.add(new Card(Card.TYPE_WHITEHAT,1));
        deckList.add(new Card(Card.TYPE_WHITEHAT,2));

        deckList.add(new Card(Card.TYPE_BLACKHAT,3));
        deckList.add(new Card(Card.TYPE_BLACKHAT,4));

        deckList.add(new Card(Card.TYPE_CRACKER,5));
        deckList.add(new Card(Card.TYPE_CRACKER,6));
        deckList.add(new Card(Card.TYPE_CRACKER,7));

        deckList.add(new Card(Card.TYPE_SKIDDIE,8));
        deckList.add(new Card(Card.TYPE_SKIDDIE,9));
        deckList.add(new Card(Card.TYPE_SKIDDIE,10));
        deckList.add(new Card(Card.TYPE_SKIDDIE,11));
    }

    public Card get_card() {
        Card retCard;
        int randomIdx = ThreadLocalRandom.current().nextInt(0, deckList.size());
        retCard = deckList.get(randomIdx);
        deckList.remove(randomIdx);
        return retCard;
    }

    public void remove_card(int id) {
        for(int i=0;i < deckList.size();i++) {
            if (id == deckList.get(i).getId()) {
                deckList.remove(i);
            }
        }
    }

    public boolean is_empty() {
        return deckList.isEmpty();
    }
}
