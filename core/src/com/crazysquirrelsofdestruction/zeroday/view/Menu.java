package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.view.components.SimpleButton;


/**
 * Created by Klaudia on 2016-04-12.
 */
public class Menu {

    SpriteBatch batch;
    Texture img;
    Texture playImage;
    Texture quitImage;
    Texture rulesImage;
    Texture settingsImage;
    SimpleButton settingsButton;
    SimpleButton rulesButton;
    SimpleButton quitButton;
    SimpleButton playButton;

    public Menu() {
        batch = new SpriteBatch();
        img = new Texture("background_and_logo.png");
        settingsImage = new Texture("settings_btn.png");
        playImage = new Texture("play_btn.png");
        quitImage = new Texture("quit_btn.png");
        rulesImage = new Texture("rules_btn.png");
        settingsButton = new SimpleButton(settingsImage,(float)(Gdx.graphics.getWidth()*0.30),(float)(Gdx.graphics.getHeight()*0.10), 561,168);
        playButton = new SimpleButton(playImage,(float)(Gdx.graphics.getWidth()*0.30),(float)(Gdx.graphics.getHeight()*0.30), 561,168);
        quitButton = new SimpleButton(quitImage,(float)(Gdx.graphics.getWidth()*0.30),(float)(Gdx.graphics.getHeight()*0.50), 561,168);
        rulesButton = new SimpleButton(rulesImage,(float)(Gdx.graphics.getWidth()*0.30),(float)(Gdx.graphics.getHeight()*0.70), 561,168);
    }

    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        settingsButton.update(batch, 0, 0);
        rulesButton.update(batch, 0, 0);
        playButton.update(batch, 0, 0);
        quitButton.update(batch, 0, 0);
        batch.end();
    }
}
