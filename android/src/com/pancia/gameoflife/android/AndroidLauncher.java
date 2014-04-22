package com.pancia.gameoflife.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.pancia.gameoflife.MyGameOfLife;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGLSurfaceView20API18 = true;
        config.useWakelock = true;
        config.useAccelerometer = false;
        config.useCompass = false;
		initialize(new MyGameOfLife(), config);
	}
}
