package com.mervus.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile{
    Sprite sprite;
    Vector2 position;

    public Tile(Vector2 position, int n)
    {
        this.position = position;
        sprite = new Sprite(new Texture("tiles/grass.png"));
        sprite.setPosition(position.x, position.y);
        sprite.setSize(MapGenerator.TILE_WIDTH,MapGenerator.TILE_HEIGHT);
    }

    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }
}
