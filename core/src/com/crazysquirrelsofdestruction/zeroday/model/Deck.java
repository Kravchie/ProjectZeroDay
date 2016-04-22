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

    public void initDeck() {
        /* Start:
            1 x Big Fish card
            2 x White hat card
            2 x Black hat card
            3 x Cracker card
            4 x Skiddie card
         */
        deckList.add(new Card(Card.TYPE_BIGFISH));

        deckList.add(new Card(Card.TYPE_WHITEHAT));
        deckList.add(new Card(Card.TYPE_WHITEHAT));

        deckList.add(new Card(Card.TYPE_BLACKHAT));
        deckList.add(new Card(Card.TYPE_BLACKHAT));

        deckList.add(new Card(Card.TYPE_CRACKER));
        deckList.add(new Card(Card.TYPE_CRACKER));
        deckList.add(new Card(Card.TYPE_CRACKER));

        deckList.add(new Card(Card.TYPE_SKIDDIE));
        deckList.add(new Card(Card.TYPE_SKIDDIE));
        deckList.add(new Card(Card.TYPE_SKIDDIE));
        deckList.add(new Card(Card.TYPE_SKIDDIE));
    }

    public Card get_card() {
        Card retCard;
        int randomIdx = ThreadLocalRandom.current().nextInt(0, deckList.size());
        retCard = deckList.get(randomIdx);
        deckList.remove(randomIdx);
        return retCard;
    }

    public void remove_card(Card card) {
        deckList.remove(card);
    }
}
