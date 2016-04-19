package com.crazysquirrelsofdestruction.zeroday.Warp;

/**
 * Created by Nadin on 4/15/2016.
 */
import java.util.HashMap;

import com.shephertz.app42.gaming.multiplayer.client.WarpClient;
import com.shephertz.app42.gaming.multiplayer.client.command.WarpResponseResultCode;
import com.shephertz.app42.gaming.multiplayer.client.events.RoomEvent;



public class WarpController {

    private static WarpController instance;

    private boolean showLog = true;

    private final String apiKey = "26bceb19547b266190199cb2742d85288f4270843d1d79775dcb7a83643644f5";
    private final String secretKey = "204b5012df91f4dfd58a70bc3ab7901a5f2b38114005e43bf6b1e715cfcda2a5";

    private WarpClient warpClient;

    private String localUser;
    private String roomId;

    private boolean isConnected = false;
    boolean isUDPEnabled = false;

    private WarpListener warpListener ;

    private int STATE;

    // Game state constants
    public static final int WAITING = 1;
    public static final int STARTED = 2;
    public static final int COMPLETED = 3;
    public static final int FINISHED = 4;

    // Game completed constants
    public static final int GAME_WIN = 5;
    public static final int GAME_LOOSE = 6;
    public static final int ENEMY_LEFT = 7;

    //info for waiting room
    public int number_of_players;

    public WarpController() {
        initAppwarp();
        warpClient.addConnectionRequestListener(new ConnectionListener(this));
        warpClient.addChatRequestListener(new ChatListener(this));
        warpClient.addZoneRequestListener(new ZoneListener(this));
        warpClient.addRoomRequestListener(new RoomListener(this));
        warpClient.addNotificationListener(new NotificationListener(this));
        number_of_players = 0;
    }

    public static WarpController getInstance(){
        if(instance == null){
            instance = new WarpController();
        }
        return instance;
    }
    public void startApp(String localUser){
        this.localUser = localUser;
        warpClient.connectWithUserName(localUser);
        //App42API.setLoggedInUser("<Logged In User>") ;
        //App42CampaignAPI.enable(true);
    }

    public void setListener(WarpListener listener){
        this.warpListener = listener;
    }

    public void stopApp(){
        if(isConnected){
            warpClient.unsubscribeRoom(roomId);
            warpClient.leaveRoom(roomId);
        }
        warpClient.disconnect();
    }

    private void initAppwarp(){
        try {
            WarpClient.initialize(apiKey, secretKey);
            //App42API.initialize(this,apiKey, secretKey);
            warpClient = WarpClient.getInstance();
            //App42API.enableEventService(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendGameUpdate(String msg){
        if(isConnected){
            if(isUDPEnabled){
                warpClient.sendUDPUpdatePeers((localUser+"#@"+msg).getBytes());
            }else{
                warpClient.sendUpdatePeers((localUser+"#@"+msg).getBytes());
            }
        }
    }

    public void updateResult(int code, String msg){
        if(isConnected){
            STATE = COMPLETED;
            HashMap<String, Object> properties = new HashMap<String, Object>();
            properties.put("result", code);
            warpClient.lockProperties(properties);
        }
    }

    public void onConnectDone(boolean status){
        log("onConnectDone: " + status);
        System.out.println("\nNDNConnected");
        if(status){
            warpClient.initUDP();
            warpClient.joinRoomInRange(1, 1, false);//1 Participant already in room
        }else{
            isConnected = false;
            handleError();
        }
    }

    public void onDisconnectDone(boolean status){

    }

    public void onRoomCreated(String roomId){
        if(roomId!=null){
            warpClient.joinRoom(roomId);
        }else{
            handleError();
        }
    }

    public void onJoinRoomDone(RoomEvent event){
        log("onJoinRoomDone: "+event.getResult());
        if(event.getResult()==WarpResponseResultCode.SUCCESS){// success case
            System.out.println("\nNDNIn room");
            this.roomId = event.getData().getId();
            warpClient.subscribeRoom(roomId);
        }else if(event.getResult()==WarpResponseResultCode.RESOURCE_NOT_FOUND){// no such room found
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("result", "");
            warpClient.createRoom("ZeroDay", "CSOD", 2, data);//2 participants in room TO TEST
            System.out.println("\nNDNIn roomCreated");
        }else{
            warpClient.disconnect();
            handleError();
        }
    }

    public void onRoomSubscribed(String roomId){
        log("onSubscribeRoomDone: "+roomId);
        if(roomId!=null){
            isConnected = true;
            warpClient.getLiveRoomInfo(roomId);
        }else{
            warpClient.disconnect();
            handleError();
        }
    }

    public void onGetLiveRoomInfo(String[] liveUsers){
        log("onGetLiveRoomInfo: "+ liveUsers.length);
        number_of_players = liveUsers.length;
        if(liveUsers!=null){
            if(liveUsers.length==2){ //StartWith2Players
                startGame();
            }else{
                waitForOtherUser();
            }
        }else{
            warpClient.disconnect();
            handleError();
        }
    }

    public int getliveUsers(){
        return number_of_players;
    }

    public void onUserJoinedRoom(String roomId, String userName){
		/*
		 * if room id is same and username is different then start the game
		 */
        if(localUser.equals(userName)==false){
            startGame();
        }
    }

    public void onSendChatDone(boolean status){
        log("onSendChatDone: "+status);
    }

    public void onGameUpdateReceived(String message){
//		log("onMoveUpdateReceived: message"+ message );
        String userName = message.substring(0, message.indexOf("#@"));
        String data = message.substring(message.indexOf("#@")+2, message.length());
        if(!localUser.equals(userName)){
            warpListener.onGameUpdateReceived(data);
        }
    }

    public void onResultUpdateReceived(String userName, int code){
        if(localUser.equals(userName)==false){
            STATE = FINISHED;
            System.out.print("\nNDNGameOver");
            warpListener.onGameFinished(code, true);
        }else{
            warpListener.onGameFinished(code, false);
        }
    }

    public void onUserLeftRoom(String roomId, String userName){
        log("onUserLeftRoom "+userName+" in room "+roomId);
        if(STATE==STARTED && !localUser.equals(userName)){// Game Started and other user left the room
            warpListener.onGameFinished(ENEMY_LEFT, true);
        }
    }

    public int getState(){
        return this.STATE;
    }

    private void log(String message){
        if(showLog){
            System.out.println(message);
        }
    }

    private void startGame(){
        STATE = STARTED;
        warpListener.onGameStarted("Start the Game");
        System.out.print("NDNEnoughPLayers");

    }

    private void waitForOtherUser(){
        STATE = WAITING;
        System.out.print("NDNWaiting for Player");
        warpListener.onWaitingStarted("Waiting for other user");
    }

    private void handleError(){
        if(roomId!=null && roomId.length()>0){
            warpClient.deleteRoom(roomId);
        }
        disconnect();
    }

    public void handleLeave(){
        if(isConnected){
            warpClient.unsubscribeRoom(roomId);
            warpClient.leaveRoom(roomId);
            if(STATE!=STARTED){
                warpClient.deleteRoom(roomId);
            }
            warpClient.disconnect();
        }
    }


private void disconnect(){
        warpClient.removeConnectionRequestListener(new ConnectionListener(this));
        warpClient.removeChatRequestListener(new ChatListener(this));
        warpClient.removeZoneRequestListener(new ZoneListener(this));
        warpClient.removeRoomRequestListener(new RoomListener(this));
        warpClient.removeNotificationListener(new NotificationListener(this));
        warpClient.disconnect();
    }

}
