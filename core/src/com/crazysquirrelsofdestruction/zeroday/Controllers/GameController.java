package com.crazysquirrelsofdestruction.zeroday.Controllers;

import com.crazysquirrelsofdestruction.zeroday.model.Game;

/**
 * Created by Klaudia on 2016-04-18.
 */
public class GameController {

    private Game GameModel;

    public GameController() {
        GameModel = new Game();
        //this.setConnection();
    }

    public void setConnection(){
        NetController startCon = new NetController();
        startCon.connect();
    }
}
