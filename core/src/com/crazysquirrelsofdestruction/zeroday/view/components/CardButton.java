package com.crazysquirrelsofdestruction.zeroday.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.Card;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;
import com.crazysquirrelsofdestruction.zeroday.view.Rules;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;

/**
 * Created by Klaudia on 2016-04-23.
 */
public class CardButton {

    private Sprite skin;
    private Texture texture_small;
    private Texture texture_big;

    public CardButton(String path, float x, float y, float width, float height) {
        this.texture_small = new Texture(path);
        texture_big = new Texture(path.replace("_small", ""));
        skin = new Sprite(texture_small); // your image
        skin.setPosition(x, y);
        skin.setSize(width, height);
    }

    public void update (SpriteBatch batch, final ZeroDayGame game) {
        skin.draw(batch); // draw the button

        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < (skin.getX() + skin.getWidth())) {
                if ((Gdx.graphics.getHeight()-Gdx.input.getY()) > skin.getY() && (Gdx.graphics.getHeight()-Gdx.input.getY()) < (skin.getY() + skin.getHeight())) {
                    game.setScreen(new Card(game, this.texture_big));
                }
            }
        }
    }
}
