package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.components.ToggleButton;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Settings implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;
    ToggleButton toggleButton;
    private BitmapFont font;

    Texture img;

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
        toggleButton.update(game.batch, this.game);
        font.draw(game.batch, "Music", (float) (Gdx.graphics.getWidth() * 0.08), (float) (Gdx.graphics.getHeight() * 0.84), (float) (Gdx.graphics.getWidth() * 0.20), -1, true);
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

    public Settings(final ZeroDayGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        toggleButton = new ToggleButton((float)(Gdx.graphics.getWidth()*0.5), (float)(Gdx.graphics.getHeight()*0.8), 153, 93);

        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(4);
        img = new Texture("background_and_logo.png");
    }

}
