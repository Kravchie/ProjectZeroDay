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
    private float x;
    private float y;
    private float h;
    private float w;

    public ToggleButton(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
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

        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > this.x && Gdx.input.getX() < (this.x + this.w)) {
                if ((Gdx.graphics.getHeight() - Gdx.input.getY()) > this.y && (Gdx.graphics.getHeight()-Gdx.input.getY()) < (this.y + this.h)) {
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