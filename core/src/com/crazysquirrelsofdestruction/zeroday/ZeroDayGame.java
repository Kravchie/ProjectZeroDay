package com.crazysquirrelsofdestruction.zeroday;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;

public class ZeroDayGame extends Game implements ApplicationListener {

	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
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
