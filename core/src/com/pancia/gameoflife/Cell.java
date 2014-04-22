package com.pancia.gameoflife;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Cell {

    private static final float SIZE = 1f;

    private Vector2 position = new Vector2();
    private Rectangle bounds = new Rectangle();

    private Boolean isAlive = false;

    public Cell(Vector2 pos) {
        this.position = pos;
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public Cell setAlive(boolean alive) {
        this.isAlive = alive;
        return this;
    }
}
