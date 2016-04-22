package com.crazysquirrelsofdestruction.zeroday.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpListener;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.model.Game;
import com.crazysquirrelsofdestruction.zeroday.view.GameBoard;
import com.crazysquirrelsofdestruction.zeroday.view.WaitingRoom;

import java.util.Random;

/**
 * Created by Klaudia on 2016-04-18.
 */
public class GameController implements WarpListener {
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
    final ZeroDayGame game;
    private Screen waitingRoom;

    public GameController(final ZeroDayGame game) {
        this.game = game;
        GameModel = new Game();
        this.onTotalPlayers();
    }

    public void onGameStarted (String message) {
        state=GAME_RUNNING;
        waitingRoom = game.getScreen();
        System.out.print("\nNDN_Going To Board Game View");
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                game.setScreen(new GameBoard(game, GameController.this));
            }
        });
    }

    public void onTotalPlayers () {
        String uniqName = getRandomHexString(10);
        WarpController.getInstance().startApp(uniqName);//Need to Take User's Name
        this.GameModel.addPlayer(uniqName, 0);
        WarpController.getInstance().setListener(this);
    }

    public Game getGameModel() {
        return GameModel;
    }

    public void onRemovePlayer(String uniqName){
        GameModel.deletePlayer(uniqName);
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

    @Override
    public void onGameUpdateReceived(String message) {

    }

    public void onWaitingStarted(String message) {
        this.msg = waitForOtherUser;
        state=GAME_READY;
        System.out.print("\nNDN_Going Waiting View");
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                //game.setScreen(new GameBoard(game, GameController.this));
                game.setScreen(new WaitingRoom(game,GameController.this));
            }
        });


    }

    public void onError (String message) {
        this.msg = errorInConnection;
    }

    public void onJoinPlayer(String uniqName){
        int ind = GameModel.getPlayers().size();
        GameModel.addPlayer(uniqName, ind);
    }

    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }

}
