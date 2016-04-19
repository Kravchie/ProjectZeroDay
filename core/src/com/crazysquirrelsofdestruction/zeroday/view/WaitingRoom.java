package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.crazysquirrelsofdestruction.zeroday.Controllers.GameController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpListener;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;

/**
 * Created by Klaudia on 2016-04-19.
 */
public class WaitingRoom implements Screen, WarpListener {
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

    final ZeroDayGame game;
    final GameController controller;

    OrthographicCamera camera;
    private BitmapFont font;

    private String text;
    private int number_of_players;

    Texture img;

    public WaitingRoom(final ZeroDayGame game) {
        this.game = game;
        this.controller = new GameController();

        number_of_players = 0;
        text = "Waiting for other players: ";

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(4);

        img = new Texture("background_and_logo.png");

        WarpController.getInstance().setListener(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        number_of_players = WarpController.getInstance().number_of_players;

        game.batch.begin();
        game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font.draw(game.batch, text + number_of_players, (float)(Gdx.graphics.getWidth()*0.20), (float)(Gdx.graphics.getHeight()*0.50), (float)(Gdx.graphics.getWidth()*0.85), -1, true);
        game.batch.end();

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
        font.dispose();
    }
}
