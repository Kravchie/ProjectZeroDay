package com.crazysquirrelsofdestruction.zeroday;

import android.os.Bundle;
//import com.shephertz.app42.gaming.multiplayer.client.WarpClient;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ZeroDayGame(), config);
		//WarpClient.initialize("26bceb19547b266190199cb2742d85288f4270843d1d79775dcb7a83643644f5","204b5012df91f4dfd58a70bc3ab7901a5f2b38114005e43bf6b1e715cfcda2a5");
	}
}
