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
}
