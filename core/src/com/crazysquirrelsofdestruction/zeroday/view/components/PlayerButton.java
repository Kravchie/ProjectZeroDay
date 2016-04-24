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
import com.crazysquirrelsofdestruction.zeroday.Controllers.GameController;
import com.crazysquirrelsofdestruction.zeroday.Warp.WarpController;
import com.crazysquirrelsofdestruction.zeroday.view.WaitingRoom;

public class PlayerButton {

    private Sprite skin;
    public int playerChosen;

    public  PlayerButton (Texture texture, float x, float y, float width, float height, int playerChosen) {
        System.out.println("NDN_CreateButton");
        skin = new Sprite(texture); // your image
        skin.setPosition(x, y);
        skin.setSize(width, height);
        this.playerChosen = playerChosen;

    }

    public void update(SpriteBatch batch, final ZeroDayGame game) {
        skin.draw(batch); // draw the button player
        System.out.println("NDN_Player Drawn");
        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > skin.getX() && Gdx.input.getX() < (skin.getX() + skin.getWidth())) {
                if ((Gdx.graphics.getHeight()-Gdx.input.getY()) > skin.getY() && (Gdx.graphics.getHeight()-Gdx.input.getY()) < (skin.getY() + skin.getHeight())) {
                    switch(this.playerChosen){
                        case 0 :
                            System.out.println("Player 1 Selected");
                            //playerNumber=1;
                            break;

                        case 1 :
                            System.out.println("Player 2 Selected");
                            //playerNumber=2;
                            break;

                        case 2 :
                            System.out.println("Player 3 Selected");
                            //playerNumber=3;
                            break;

                    }

                }
            }
        }

    }

}
