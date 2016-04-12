package com.crazysquirrelsofdestruction.zeroday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crazysquirrelsofdestruction.zeroday.view.Menu;

public class ZeroDayGame extends ApplicationAdapter {
	
	@Override
	public void create () {
	}

	@Override
	public void render () {
		Menu menu = new Menu();
		menu.render();
	}
}
