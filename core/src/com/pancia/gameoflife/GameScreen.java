package com.pancia.gameoflife;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

    private World myWorld;
    private WorldRenderer myRenderer;
    private long lastUpdateTime;

    @Override
    public void show() {
        myWorld = new World();
        myRenderer = new WorldRenderer(myWorld);
    }

    @Override
    public void render(float delta) {
        if (System.currentTimeMillis() > lastUpdateTime + 150) {
            myRenderer.update();
            lastUpdateTime = System.currentTimeMillis();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        myRenderer.render();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void hide() {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}

}
