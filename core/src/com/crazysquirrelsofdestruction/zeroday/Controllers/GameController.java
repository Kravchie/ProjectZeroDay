package com.crazysquirrelsofdestruction.zeroday.Controllers;

import com.badlogic.gdx.Gdx;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.model.Game;
//import com.crazysquirrelsofdestruction.zeroday.view.GameTable;

/**
 * Created by Klaudia on 2016-04-18.
 */
public class GameController {
    static final int GAME_READY = 0;
    static final int GAME_RUNNING = 1;
    static final int GAME_PAUSED = 2;
    static final int GAME_LEVEL_END = 3;
    static final int GAME_OVER = 4;
    int state;
    private Game GameModel;
    private final String  tryingToConnect = "Connecting to AppWarp";
    private final String  waitForOtherUser = "Waiting for other user";
    private final String  errorInConnection = "Error in Connection Go Back";
    private final String   game_win = "Congrats You Win! Enemy Defeated";
    private final String   game_loose = "Oops You Loose! Target Achieved By Enemy";
    private final String   enemy_left = "Congrats You Win! Enemy Left the Game";
    private String msg = tryingToConnect;

    public GameController() {
        GameModel = new Game();
        state=GAME_READY;
        //this.setConnection();

    }

    public void onGameStarted (String message) {
        state=GAME_RUNNING;
    }

    public void onGameFinished (int code, boolean isRemote) {
        if(code== WarpController.GAME_WIN){
            this.msg = game_loose;
        }else if(code==WarpController.GAME_LOOSE){
            this.msg = game_win;
        }else if(code==WarpController.ENEMY_LEFT){
            this.msg = enemy_left;
        }
        //***BACK TO MENU***
    }
    public void onWaitingStarted(String message) {
        this.msg = waitForOtherUser;

    }

    public void onError (String message) {
        this.msg = errorInConnection;

    }

}
