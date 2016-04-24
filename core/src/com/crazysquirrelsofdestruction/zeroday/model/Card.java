package com.crazysquirrelsofdestruction.zeroday.model;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Card {
    /* Constants */
    public static final int TYPE_BIGFISH = 0;
    public static final int TYPE_WHITEHAT = 1;
    public static final int TYPE_BLACKHAT = 2;
    public static final int TYPE_CRACKER = 3;
    public static final int TYPE_SKIDDIE = 4;

    private int type;
    private int id;

    public int getId() {
        return id;
    }

    public Card(int type, int id) {
        this.type = type;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getCardImage(int type) {
        String path = "";
        switch(type){
            case TYPE_BIGFISH:
                path = "BigFish_card_small.png";
            break;
            case TYPE_WHITEHAT:
                path = "WhiteHat_card_small.png";
            break;
            case TYPE_BLACKHAT:
                path = "BlackHat_card_small.png";
            break;
            case TYPE_CRACKER:
                path = "Cracker_card_small.png";
            break;
            case TYPE_SKIDDIE:
                path = "Skiddie_card_small.png";
            break;
        }
        return path;
    }
}
