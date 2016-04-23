package com.crazysquirrelsofdestruction.zeroday.model;

/**
 * Created by otorr on 22/04/2016.
 */

public class Move {

    /* Move attributes */
    private int cardType;
    private String senderId;
    private String action;

    public Move(String senderId, int cardType, String action) {
        this.senderId = senderId;
        this.cardType = cardType;
        this.action = action;
    }

    public int getCardType() {
        return cardType;
    }

    public String getAction() {
        return action;
    }

    public String getSenderId() {
        return senderId;
    }
}
