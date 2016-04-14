package com.crazysquirrelsofdestruction.zeroday.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;
import com.crazysquirrelsofdestruction.zeroday.view.Rules;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;

public class SimpleButton {

    private Sprite skin;
    private int type;

    public SimpleButton(Texture texture, float x, float y, float width, float height, int type) {
        skin = new Sprite(texture); // your image
        skin.setPosition(x, y);
        skin.setSize(width, height);
        this.type = type;
    }

    public void update (SpriteBatch batch, final ZeroDayGame game, Menu menu) {
        skin.draw(batch); // draw the button

        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < skin.getX() + skin.getWidth()) {
                if (Gdx.input.getY() > skin.getY() && Gdx.input.getY() < Gdx.input.getY() + skin.getHeight()) {
                    switch(this.type){
                        case 1 : {
                            game.setScreen(new Settings(game));
                            break;
                        }
                        case 2 : {
                            game.setScreen(new Settings(game));
                            break;
                        }
                        case 3 : {
                            game.setScreen(new Settings(game));
                            break;
                        }
                        case 4 : {
                            game.setScreen(new Settings(game));
                            break;
                        }
                    }
                    menu.dispose();
                }
            }
        }
    }
}