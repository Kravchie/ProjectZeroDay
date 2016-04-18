package com.crazysquirrelsofdestruction.zeroday.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;
import com.crazysquirrelsofdestruction.zeroday.view.Rules;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;
import com.crazysquirrelsofdestruction.zeroday.Controllers.NetController;

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
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < (skin.getX() + skin.getWidth())) {
                if (Gdx.input.getY() > skin.getY() && Gdx.input.getY() < (skin.getY() + skin.getHeight())) {
                    switch(this.type){
                        case 1 :
                            System.out.println("Play button clicked");
                            game.setScreen(new Settings(game));
                            NetController startCon = new NetController();
                            startCon.connect();
                            break;

                        case 2 :
                            System.out.println("Settings button clicked");
                            game.setScreen(new Settings(game));
                            break;

                        case 3 :
                            System.out.println("Rules button clicked");
                            game.setScreen(new Rules(game));
                            break;

                        case 4 :
                            System.out.println("Quit button clicked");
                            Gdx.app.exit();
                            break;

                    }
                    menu.dispose();
                }
            }
        }
    }
}