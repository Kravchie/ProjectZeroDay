/*package com.crazysquirrelsofdestruction.zeroday.view;

/**
 * Created by Nadin on 4/19/2016.

import com.crazysquirrelsofdestruction.zeroday.Controllers.GamePlayTest;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;

public class GameTable  implements Screen, WarpListener {
    static final int GAME_READY = 0;
    static final int GAME_RUNNING = 1;
    static final int GAME_PAUSED = 2;
    static final int GAME_LEVEL_END = 3;
    static final int GAME_OVER = 4;
    Game game;
    int state;
    OrthographicCamera guiCam;
    Vector3 touchPoint;
    SpriteBatch batcher;
    Rectangle pauseBounds;
    Rectangle resumeBounds;
    Rectangle quitBounds;
    int lastScore;
    String scoreString;
    private GamePlayTest prevScreen;
    public static Texture items;

    public GameTable (Game game, GamePlayTest prevScreen) {
        this.game = game;
        this.prevScreen = prevScreen;
        state = GAME_RUNNING;
        System.out.print("NDNInserted Table Started");
        guiCam = new OrthographicCamera(320, 480);
        guiCam.position.set(320 / 2, 480 / 2, 0);
        touchPoint = new Vector3();
        batcher = new SpriteBatch();
        WarpController.getInstance().setListener(this);
    }
    public void update (float deltaTime) {
        if (deltaTime > 0.1f) deltaTime = 0.1f;

        updateReady();

    }
    private void updateReady () {
        if (Gdx.input.justTouched()) {
            state = GAME_RUNNING;

        }
    }
    public void draw () {
        GL20 gl = Gdx.gl;
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCam.update();
        batcher.setProjectionMatrix(guiCam.combined);
        batcher.enableBlending();
        batcher.begin();
        presentReady();
        batcher.end();

    }
    private void presentReady () {

        items = new Texture("items.png");
        batcher.draw(new TextureRegion (items, 320, 224, 192, 32),160 - 192 / 2, 240 - 32 / 2, 192, 32);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void onWaitingStarted(String message) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onGameStarted(String message) {

    }

    @Override
    public void onGameFinished(int code, boolean isRemote) {

    }

    @Override
    public void onGameUpdateReceived(String message) {

    }
}
*/