package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.HashMap;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Player {

    private HashMap deck;
    private int points;

    public Player(){
        deck = new HashMap();
        points = 0;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }
}
