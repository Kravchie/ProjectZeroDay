package com.crazysquirrelsofdestruction.zeroday.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SimpleButton {

    private Sprite skin;

    public SimpleButton(Texture texture, float x, float y, float width, float height) {
        skin = new Sprite(texture); // your image
        skin.setPosition(x, y);
        skin.setSize(width, height);
    }

    public void update (SpriteBatch batch) {
        skin.draw(batch); // draw the button

        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < skin.getX() + skin.getWidth()) {
                if (Gdx.input.getY() > skin.getY() && Gdx.input.getY() < Gdx.input.getY() + skin.getHeight()) {
                    System.out.println("Button clicked !");
                }
            }
        }
    }
}