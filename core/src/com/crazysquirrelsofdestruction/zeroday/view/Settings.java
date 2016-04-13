package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.view.components.SimpleButton;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Settings {
    SpriteBatch batch;
    Texture img;
    Texture buttonImage;
    SimpleButton settingsButton;

    public Settings() {
        batch = new SpriteBatch();
        img = new Texture("table.jpg");

        settingsButton = new SimpleButton(buttonImage,0,0, 561,168);
    }

    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        settingsButton.update(batch);
        batch.end();
    }
}
