package com.crazysquirrelsofdestruction.zeroday.view.components;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;
import com.crazysquirrelsofdestruction.zeroday.view.Rules;
import com.crazysquirrelsofdestruction.zeroday.view.Settings;
import com.crazysquirrelsofdestruction.zeroday.Controllers.NetController;
import com.crazysquirrelsofdestruction.zeroday.Controllers.GamePlayTest;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.view.WaitingRoom;

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

        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < (skin.getX() + skin.getWidth())) {
                if ((Gdx.graphics.getHeight()-Gdx.input.getY()) > skin.getY() && (Gdx.graphics.getHeight()-Gdx.input.getY()) < (skin.getY() + skin.getHeight())) {
                    switch(this.type){
                        case 1 :
                            System.out.println("Play button clicked");
                            //game.setScreen(new GamePlayTest(game));
                            WarpController.getInstance().startApp(getRandomHexString(10));//Need to Take User's Name
                            game.setScreen(new WaitingRoom(game));
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
    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }
}