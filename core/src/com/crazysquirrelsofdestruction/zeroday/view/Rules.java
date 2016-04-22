package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Rules implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;
    private BitmapFont font;
    private FileHandle file;
    private String rules;
    private int width;
    private int height;
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
        font.draw(game.batch, rules, (float)(width*0.08), (float)(height*0.90), (float)(width*0.85), -1, true);
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

    public Rules(final ZeroDayGame game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        file = Gdx.files.internal("rules.txt");
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale((float)2.3);
        rules = file.readString();

        img = new Texture("background_and_logo.png");
    }
}
