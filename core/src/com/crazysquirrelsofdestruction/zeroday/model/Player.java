package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.HashMap;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Player {

    private Deck deck;
    private int status;
    private int points;
    private int id;

    public Player(){
        deck = new Deck();
        points = 0;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }
}
