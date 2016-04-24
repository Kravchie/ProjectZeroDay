package com.crazysquirrelsofdestruction.zeroday.model;

/**
 * Created by otorr on 22/04/2016.
 */

public class Move {

    /* Move attributes */
    private int value;
    private String senderId;
    private String action;

    public Move(String senderId, int cardType, String action) {
        this.senderId = senderId;
        this.value = cardType;
        this.action = action;
    }

    public int getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }

    public String getSenderId() {
        return senderId;
    }
}
