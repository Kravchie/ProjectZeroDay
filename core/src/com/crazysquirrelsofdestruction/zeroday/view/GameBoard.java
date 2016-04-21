package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.crazysquirrelsofdestruction.zeroday.Controllers.GameController;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;



/**
 * Created by Klaudia on 2016-04-18.
 */

public class GameBoard implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;

    final GameController controller;

    Texture img;
    Texture table;

    public GameBoard(final ZeroDayGame game, final GameController controller) { //DELETED FINAL for GameController

        this.game = game;
        this.controller = controller;
        System.out.print("\nNDN_IN GAME BOARD");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        img = new Texture("background_and_logo.png");
        table = new Texture("table.png");
        //WarpController.getInstance().setListener(this);
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

        game.batch.begin();
        game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(table, (float)(Gdx.graphics.getWidth()*0.30), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.4), Gdx.graphics.getHeight()/3);

        game.batch.end();

        //update game model
        //draw background
        //draw table
        //draw players

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

}
