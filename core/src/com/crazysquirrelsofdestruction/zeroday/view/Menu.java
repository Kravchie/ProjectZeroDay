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
    Texture buttonImage;
    SimpleButton settingsButton;

    public Menu() {
        batch = new SpriteBatch();
        img = new Texture("table.jpg");
        buttonImage = new Texture("settings_btn.png");
        settingsButton = new SimpleButton(buttonImage,0,0, 561,168);
    }

    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        settingsButton.update(batch,0,0);
        batch.end();
    }
}
