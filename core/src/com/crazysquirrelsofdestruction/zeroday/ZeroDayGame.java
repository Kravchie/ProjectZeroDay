package com.crazysquirrelsofdestruction.zeroday;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;

public class ZeroDayGame extends Game implements ApplicationListener, InputProcessor {

	public SpriteBatch batch;

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.BACK){
			this.setScreen(new Menu(this));
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		this.setScreen(new Menu(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose(){
		batch.dispose();
	}
}
