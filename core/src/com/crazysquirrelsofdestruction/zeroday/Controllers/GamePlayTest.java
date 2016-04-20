/*package com.crazysquirrelsofdestruction.zeroday.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpListener;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.GameTable;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;
import com.crazysquirrelsofdestruction.zeroday.view.WaitingRoom;

/**
 * Created by Nadin on 4/19/2016.

public class GamePlayTest implements  WarpListener {
    final ZeroDayGame game;
    OrthographicCamera guiCam;
    SpriteBatch batcher;
    Rectangle backBounds;
    Vector3 touchPoint;
    Texture backgroundRegion;
    public static BitmapFont font;
    private static GlyphLayout glyphLayout = new GlyphLayout();

    float xOffset = 0;

    private final String  tryingToConnect = "Connecting to AppWarp";
    private final String  waitForOtherUser = "Waiting for other user";
    private final String  errorInConnection = "Error in Connection Go Back";
    private final String   game_win = "Congrats You Win! Enemy Defeated";
    private final String   game_loose = "Oops You Loose! Target Achieved By Enemy";
    private final String   enemy_left = "Congrats You Win! Enemy Left the Game";

    private String msg = tryingToConnect;

    public GamePlayTest (final ZeroDayGame game) {
        this.game = game;
       guiCam = new OrthographicCamera(320, 480);
        guiCam.position.set(320 / 2, 480 / 2, 0);
        backBounds = new Rectangle(0, 0, 64, 64);
        touchPoint = new Vector3();
        batcher = new SpriteBatch();
        xOffset = 80;
        WarpController.getInstance().setListener(this);

    }

    public void update () {
        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (backBounds.contains(touchPoint.x, touchPoint.y)) {
                System.out.print("Touch point touched");
                game.setScreen(new WaitingRoom(game));
                WarpController.getInstance().handleLeave();
                return;
            }



    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
        guiCam.update();
        batcher.setProjectionMatrix(guiCam.combined);
        batcher.disableBlending();
        batcher.begin();
        backgroundRegion = new Texture("background_and_logo.png");
        batcher.draw(backgroundRegion, 0, 0, 320, 480);
        batcher.end();
        batcher.enableBlending();
        System.out.print("NDNInserted"+msg);
        batcher.begin();
        float y = 230;
        float x = 230;
        glyphLayout.setText(font, msg);
        font.draw(batcher,glyphLayout, x + glyphLayout.width / 3, y + glyphLayout.height / 3);
        y += glyphLayout.height;

            for (int i = msg.length-1; i >= 0; i--) {
                float width = Assets.font.getBounds(msg[i]).width;
                Assets.font.draw(batcher, msg[i], 160-width/2, y);
                y += Assets.font.getLineHeight();
            }
        batcher.end();

    }

    @Override
    public void render (float delta) {
        update();
        draw();
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void show () {
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose () {
    }

    @Override
    public void onError (String message) {
        this.msg = errorInConnection;
        update();
    }

    @Override//WAITING ROOM
    public void onGameStarted (String message) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run () {
                game.setScreen(new GameTable(game, GamePlayTest.this));
            }
        });

    }

    @Override
    public void onGameFinished (int code, boolean isRemote) {
        if(code==WarpController.GAME_WIN){
            this.msg = game_loose;
        }else if(code==WarpController.GAME_LOOSE){
            this.msg = game_win;
        }else if(code==WarpController.ENEMY_LEFT){
            this.msg = enemy_left;
        }
        update();
        //game.setScreen();//BacktoMenu
    }

    @Override
    public void onGameUpdateReceived (String message) {

    }

    @Override
    public void onWaitingStarted(String message) {
        this.msg = waitForOtherUser;
        update();
    }
    public void onError (String message) {
        this.msg = errorInConnection;

    }

}*/
