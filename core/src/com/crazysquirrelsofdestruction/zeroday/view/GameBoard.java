package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.crazysquirrelsofdestruction.zeroday.Controllers.GameController;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.model.Card;

import java.util.ArrayList;


/**
 * Created by Klaudia on 2016-04-18.
 */

public class GameBoard implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;

    final GameController controller;

    Texture img;
    Texture table;
    Texture[] textures;


    public GameBoard(final ZeroDayGame game, final GameController controller) { //DELETED FINAL for GameController

        this.game = game;
        this.controller = controller;
        System.out.print("\nNDN_IN GAME BOARD");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        img = new Texture("background_and_logo.png");
        table = new Texture("table.png");
        textures = new Texture[controller.getGameModel().getPlayers().size()];
        for(int i=0; i < controller.getGameModel().getPlayers().size()-1; i++ ){
            textures[i] = new Texture("player" + (i+1) + ".png");
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(table, (float)(Gdx.graphics.getWidth()*0.30), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.4), Gdx.graphics.getHeight()/3);
        for(int i=0; i < controller.getGameModel().getPlayers().size()-1; i++ ){
            switch (i) {
                case 0:
                    game.batch.draw(textures[i], (float)(Gdx.graphics.getWidth()*0.35), (float)(Gdx.graphics.getHeight()*0.70), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
                case 1:
                    game.batch.draw(textures[i], (float)(Gdx.graphics.getWidth()*0.05), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
                case 2:
                    game.batch.draw(textures[i], (float)(Gdx.graphics.getWidth()*0.65), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
            }
        }


        game.gameController.initTurn();
        //Card userCard = game.gameController.getGameModel().getLocalPlayer().getCards()[0];
        //game.batch.draw(new Texture(userCard.getCardImage(userCard.getType())), (float)(Gdx.graphics.getWidth()*0.15), (float)(Gdx.graphics.getHeight()*0.05), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.3));
        drawCards();

        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void drawCards(){
        if(game.gameController.isMyTurn()) {
            Card userCard = game.gameController.getGameModel().getLocalPlayer().getCards()[0];
            Card userCard2 = game.gameController.getGameModel().getLocalPlayer().getCards()[1];
            game.batch.draw(new Texture(userCard.getCardImage(userCard.getType())), (float) (Gdx.graphics.getWidth() * 0.15), (float) (Gdx.graphics.getHeight() * 0.05), (float) (Gdx.graphics.getWidth() * 0.3), (float) (Gdx.graphics.getHeight() * 0.3));
            if (!(userCard2 == null))
                game.batch.draw(new Texture(userCard2.getCardImage(userCard.getType())), (float) (Gdx.graphics.getWidth() * 0.35), (float) (Gdx.graphics.getHeight() * 0.05), (float) (Gdx.graphics.getWidth() * 0.3), (float) (Gdx.graphics.getHeight() * 0.3));
        }

    }

}
