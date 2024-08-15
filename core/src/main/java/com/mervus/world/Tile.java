package com.mervus.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mervus.Main;

public class Tile{
    ShapeRenderer shape;
    private int x;
    private int y;

    public Tile(int x, int y, int n)
    {
        shape = new ShapeRenderer();
        this.x = x;
        this.y = y;

        shape.setColor(n % 2 < 1 ? Color.RED : Color.GREEN);
    }

    public void render(SpriteBatch batch)
    {

        shape.setProjectionMatrix(Main.getInstance().camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(this.x, this.y, 10, 10);
        shape.end();
    }
}
