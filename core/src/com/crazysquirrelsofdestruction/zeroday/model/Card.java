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

    public Card(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getCardImage(int type) {
        String path = "";
        switch(type){
            case TYPE_BIGFISH:
                path = "BigFish_card.png";
            break;
            case TYPE_WHITEHAT:
                path = "WhiteHat_card.png";
            break;
            case TYPE_BLACKHAT:
                path = "BlackHat_card.png";
            break;
            case TYPE_CRACKER:
                path = "Cracker_card.png";
            break;
            case TYPE_SKIDDIE:
                path = "Skiddie_card.png";
            break;
        }
        return path;
    }
}
