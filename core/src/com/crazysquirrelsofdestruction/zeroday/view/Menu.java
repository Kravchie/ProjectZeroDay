package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.components.SimpleButton;



/**
 * Created by Klaudia on 2016-04-12.
 */
public class Menu implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;

    Texture img;
    Texture playImage;
    Texture quitImage;
    Texture rulesImage;
    Texture settingsImage;
    SimpleButton settingsButton;
    SimpleButton rulesButton;
    SimpleButton quitButton;
    SimpleButton playButton;

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
        playButton.update(game.batch, this.game, this);
        rulesButton.update(game.batch, this.game, this);
        settingsButton.update(game.batch, this.game, this);
        quitButton.update(game.batch, this.game, this);
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

    }


    public Menu(final ZeroDayGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        img = new Texture("background_and_logo.png");
        settingsImage = new Texture("settings_btn.png");
        playImage = new Texture("play_btn.png");
        quitImage = new Texture("quit_btn.png");
        rulesImage = new Texture("rules_btn.png");
        quitButton = new SimpleButton(quitImage,(float)(Gdx.graphics.getWidth()*0.25),(float)(Gdx.graphics.getHeight()*0.20), 561,168, 1);
        settingsButton = new SimpleButton(settingsImage,(float)(Gdx.graphics.getWidth()*0.25),(float)(Gdx.graphics.getHeight()*0.35), 561,168, 3);
        rulesButton = new SimpleButton(rulesImage,(float)(Gdx.graphics.getWidth()*0.25),(float)(Gdx.graphics.getHeight()*0.50), 561,168, 2);
        playButton = new SimpleButton(playImage,(float)(Gdx.graphics.getWidth()*0.25),(float)(Gdx.graphics.getHeight()*0.65), 561,168, 4);
    }
}
