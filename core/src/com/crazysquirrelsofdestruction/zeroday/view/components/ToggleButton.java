package com.crazysquirrelsofdestruction.zeroday.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.Controllers.NetController;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;
import com.crazysquirrelsofdestruction.zeroday.view.Rules;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;

public class ToggleButton {

    private Sprite checked_skin;
    private Sprite unchecked_skin;
    private Texture toggle_on;
    private Texture toggle_off;
    private float xx;
    private float yy;
    private float hh;
    private float ww;

    public ToggleButton(float x, float y, float width, float height) {
        xx = x;
        yy = y;
        ww = width;
        hh = height;
        toggle_on = new Texture("toggle_on.png");
        toggle_off = new Texture("toggle_off.png");
        checked_skin = new Sprite(toggle_on);
        unchecked_skin = new Sprite(toggle_off);
        checked_skin.setPosition(x, y);
        checked_skin.setSize(width, height);
        unchecked_skin.setPosition(x, y);
        unchecked_skin.setSize(width, height);
    }

    public void update (SpriteBatch batch, final ZeroDayGame game) {

        if(game.settings.getMusic().equals(true)){
            checked_skin.draw(batch);
        }
        else{
            unchecked_skin.draw(batch);
        }

        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX() > xx && Gdx.input.getX() < (xx + ww)) {
                if ((Gdx.graphics.getHeight() - Gdx.input.getY()) > yy && (Gdx.graphics.getHeight()-Gdx.input.getY()) < (yy + hh)) {
                    if(game.settings.getMusic().equals(true)){
                        game.settings.setMusic(false);
                    }
                    else{
                        game.settings.setMusic(true);
                    }
                }
            }
        }
    }
}