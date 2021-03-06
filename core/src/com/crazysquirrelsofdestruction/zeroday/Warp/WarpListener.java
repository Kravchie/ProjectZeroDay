package com.crazysquirrelsofdestruction.zeroday.Warp;

/**
 * Created by Nadin on 4/16/2016.
 */
public interface WarpListener {

    public void onWaitingStarted(String message);

    public void onError(String message);

    public void onGameStarted(String message);

    public void onGameFinished(int code, boolean isRemote);

    public void onGameUpdateReceived(String message);

    public void onJoinPlayer(String uniqName);

    public void onRemovePlayer(String uniqName);

    public void onAssignTurn(int placeInTurn);

    public void onAddOrdered(String uniqName, int index);
}
