package com.pancia.gameoflife;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {

    private World myWorld;
    private OrthographicCamera cam;

    ShapeRenderer debugRenderer = new ShapeRenderer();

    public WorldRenderer(World world) {
        this.myWorld = world;
        this.cam = new OrthographicCamera(10, 10); //TODO CHANGE FROM DEFAULT VALUES
        this.cam.position.set(5, 5, 0);
        this.cam.update();
    }

    public void render() {
        //render blocks
        debugRenderer.setProjectionMatrix(cam.combined);
        for (Cell[] cellRow : myWorld.getGameBoard()) {
            for (Cell cell : cellRow) {
                Rectangle rect = cell.getBounds();
                float x1 = cell.getPosition().x + rect.x;
                float y1 = cell.getPosition().y + rect.y;
                debugRenderer.begin(ShapeRenderer.ShapeType.Line);
                debugRenderer.setColor(new Color(1, 0, 0, 1));
                debugRenderer.rect(x1, y1, rect.width, rect.height);
                debugRenderer.end();
                if (cell.isAlive()) {
                    debugRenderer.begin(ShapeRenderer.ShapeType.Filled);
                    debugRenderer.setColor(new Color(0, 1, 0, 1));
                    debugRenderer.rect(x1, y1, rect.width, rect.height);
                    debugRenderer.end();
                }
            }
        }
        debugRenderer.end();
    }

    public void update() {
        myWorld.update();
    }
}
