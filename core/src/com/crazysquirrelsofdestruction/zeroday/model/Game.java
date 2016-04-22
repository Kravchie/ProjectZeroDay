package com.crazysquirrelsofdestruction.zeroday.model;

import java.util.HashMap;

/**
 * Created by Klaudia on 2016-04-18.
 */
public class Game {

    private HashMap players;
    private Player[] players_in;
    private Table table;
    private Card[] deck;

    public Game() {
        this.players = new HashMap(); //object player + id as a key
        this.table = new Table();
    }

    public HashMap getPlayers() {
        return players;
    }

    public void addPlayer(String uniqName, int index) {
        this.players.put(uniqName, index);
    }

    public void deletePlayer(String uniqName) {
        this.players.remove(uniqName);
    }
}
