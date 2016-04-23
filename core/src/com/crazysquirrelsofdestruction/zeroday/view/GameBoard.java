package com.crazysquirrelsofdestruction.zeroday.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.crazysquirrelsofdestruction.zeroday.Controllers.GameController;
import com.crazysquirrelsofdestruction.zeroday.ZeroDayGame;
import com.crazysquirrelsofdestruction.zeroday.model.Card;
import com.crazysquirrelsofdestruction.zeroday.view.components.CardButton;


/**
 * Created by Klaudia on 2016-04-18.
 */

public class GameBoard implements Screen {

    final ZeroDayGame game;
    OrthographicCamera camera;

    final GameController controller;

    Texture img;
    Texture table;
    Texture[] texturesPlayers;
    Texture[] texturesCards;
    CardButton cardButton1;
    CardButton cardButton2;
    private int card_displayed;
    //private Boolean initState;


    public GameBoard(final ZeroDayGame game, final GameController controller) { //DELETED FINAL for GameController
        card_displayed = 0;
        this.game = game;
        this.controller = controller;
        System.out.println("NDN_IN GAME BOARD");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        img = new Texture("background_and_logo.png");
        table = new Texture("table.png");
        texturesPlayers = new Texture[controller.getGameModel().getPlayers().size()];
        for(int i=0; i < controller.getGameModel().getPlayers().size()-1; i++ ){
            texturesPlayers[i] = new Texture("player" + (i+1) + ".png");
        }

        texturesCards = new Texture[5];

        for(int i=0; i < 5; i++){
            Card sampleCard = new Card(i);
            texturesCards[i] = new Texture(sampleCard.getCardImage(i));
        }

        //initState = true;

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
        game.batch.draw(table, (float) (Gdx.graphics.getWidth() * 0.30), (float) (Gdx.graphics.getHeight() * 0.35), (float) (Gdx.graphics.getWidth() * 0.4), Gdx.graphics.getHeight() / 3);
        for(int i=0; i < controller.getGameModel().getPlayers().size()-1; i++ ){
            switch (i) {
                case 0:
                    game.batch.draw(texturesPlayers[i], (float)(Gdx.graphics.getWidth()*0.35), (float)(Gdx.graphics.getHeight()*0.70), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
                case 1:
                    game.batch.draw(texturesPlayers[i], (float)(Gdx.graphics.getWidth()*0.05), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
                case 2:
                    game.batch.draw(texturesPlayers[i], (float)(Gdx.graphics.getWidth()*0.65), (float)(Gdx.graphics.getHeight()*0.35), (float)(Gdx.graphics.getWidth()*0.3), (float)(Gdx.graphics.getHeight()*0.2));
                    break;
            }
        }

        if(game.gameController.getGameModel().getLocalPlayer().getCards()[0].equals(null)) {
            /*Boolean init = */game.gameController.initTurn();
            //initState = init;
            if(game.gameController.getGameModel().getLocalPlayer().getInQueue()+1 == 4){
                game.gameController.getGameModel().getTable().setRoundCounter(1);
            }else{
                game.gameController.getGameModel().getTable().setRoundCounter(game.gameController.getGameModel().getLocalPlayer().getInQueue()+1);
            }
            System.out.println("KK: Player = " + game.gameController.getGameModel().getLocalPlayer().getInQueue() + " length of deck = " + game.gameController.getGameModel().getTable().getDeck().getDeckSize());
        } else {
            drawCards();
        }

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
            Card userCard = game.gameController.getGameModel().getLocalPlayer().getCards()[0];
            Card userCard2 = game.gameController.getGameModel().getLocalPlayer().getCards()[1];
            int typ1 = game.gameController.getGameModel().getLocalPlayer().getCards()[0].getType();
            if(card_displayed == 0) {
                cardButton1 = new CardButton(game.gameController.getGameModel().getLocalPlayer().getCards()[0].getCardImage(typ1), (float) (Gdx.graphics.getWidth() * 0.05), (float) (Gdx.graphics.getHeight() * 0.01), (float) (Gdx.graphics.getWidth() * 0.4), (float) (Gdx.graphics.getHeight() * 0.4));
                card_displayed = 1;
            }
                cardButton1.update(game.batch, this.game);
            if (!(userCard2 == null)) {
                int typ2 = game.gameController.getGameModel().getLocalPlayer().getCards()[1].getType();
                if(card_displayed == 1) {
                    cardButton2 = new CardButton(game.gameController.getGameModel().getLocalPlayer().getCards()[1].getCardImage(typ2), (float) (Gdx.graphics.getWidth() * 0.01), (float) (Gdx.graphics.getHeight() * 0.01), (float) (Gdx.graphics.getWidth() * 0.4), (float) (Gdx.graphics.getHeight() * 0.4));
                    card_displayed = 2;
                }
                    cardButton2.update(game.batch, this.game);
         }


    }
}
