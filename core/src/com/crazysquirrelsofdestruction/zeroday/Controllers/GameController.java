package com.crazysquirrelsofdestruction.zeroday.Controllers;

import com.badlogic.gdx.Gdx;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpListener;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.model.Card;
import com.crazysquirrelsofdestruction.zeroday.model.Game;
import com.crazysquirrelsofdestruction.zeroday.model.Move;
import com.crazysquirrelsofdestruction.zeroday.model.Player;
import com.crazysquirrelsofdestruction.zeroday.view.GameBoard;
import com.crazysquirrelsofdestruction.zeroday.view.WaitingRoom;
import com.google.gson.Gson;

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
    private Gson gson;


    public GameController(final ZeroDayGame game) {
        this.game = game;
        GameModel = new Game();
        this.onTotalPlayers();
        gson = new Gson();
    }

    private void init_game() {

    }

    public void onGameStarted (String message) {
        state = GAME_RUNNING;
        init_game();
        System.out.println("NDN_Going To Board Game View");
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                game.setScreen(new GameBoard(game, GameController.this));
            }
        });

        System.out.println("KK: My place in queue = " + this.GameModel.getLocalPlayer().getInQueue());
        System.out.println("KK: Ordered Player Hashmap in Table = " + this.GameModel.getTable().getOrderedPlayers());
    }

    public void onTotalPlayers () {
        String uniqName = getRandomHexString(10);
        WarpController.getInstance().startApp(uniqName);//Need to Take User's Name
        this.GameModel.addPlayer(uniqName, 0);
        this.GameModel.setLocalPlayer(new Player(uniqName));
        WarpController.getInstance().setListener(this);
    }

    public Game getGameModel() {
        return GameModel;
    }

    public void onRemovePlayer(String uniqName){
        GameModel.deletePlayer(uniqName);
        GameModel.getTable().deleteOrderedPlayer(uniqName);
        System.out.println("KK: Ordered Player Hashmap in Table = " + this.GameModel.getTable().getOrderedPlayers());
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
        Move move = gson.fromJson(message, Move.class);
        if (move.getAction() == "W") {
            Card deckCard = new Card(move.getCardType());
            System.out.println("onGameUpdateReceived: deckCardType = " + String.valueOf(deckCard.getType()));
            this.GameModel.getTable().getDeck().remove_card(deckCard);
        }
    }

    public void onWaitingStarted(String message) {
        this.msg = waitForOtherUser;
        state = GAME_READY;
        System.out.println("NDN_Going Waiting View");
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                game.setScreen(new WaitingRoom(game,GameController.this));
            }
        });

    }

    public void onAssignTurn(int placeInTurn){
        this.GameModel.getLocalPlayer().setInQueue(placeInTurn);
    }

    public void onError (String message) {
        this.msg = errorInConnection;
    }

    public void onJoinPlayer(String uniqName){
        int ind = GameModel.getPlayers().size();
        GameModel.addPlayer(uniqName, ind);
    }

    @Override
    public void onAddOrdered(String uniqName, int index) {
        this.GameModel.getTable().setOrderedPlayers(uniqName, index);
    }

    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }

    public Boolean isMyTurn(){
        if(this.GameModel.getLocalPlayer().getInQueue() == this.GameModel.getTable().getRoundCounter()){
            return true;
        } else{
            return false;
        }
    }

    public void initTurn(){
        if(!GameModel.getLocalPlayer().getInitState()) {
            Card deckCard = this.GameModel.getDeckCard();
            Move move = new Move(GameModel.getLocalPlayer().getUniqName(), deckCard.getType(), "W");
            String data = gson.toJson(move);
            System.out.println("initTurn: data = " + data);
            WarpController.getInstance().sendGameUpdate(data);
            this.GameModel.getLocalPlayer().setCard(deckCard);
            System.out.println("KK: Player = " + GameModel.getLocalPlayer().getInQueue() + " length of deck = " + GameModel.getTable().getDeck().getDeckSize());
        }
    }
    public void turn(){
        if(isMyTurn()) {
            //choose the card (double click?) and set in Player:chosenCard
            //send a message with chosen action
            //wait for response if necessary
            //end turn, increase roundcounter

        }
    }

}
