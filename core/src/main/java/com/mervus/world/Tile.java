package com.mervus.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile{
    Sprite sprite;
    Vector2 position;
    boolean isWalkable;
    TileType tileType;

    public Tile(Vector2 position, TileType tileType)
    {
        this.position = position;
        String texturePath = null;
        switch (tileType)
        {
            case GRASS:
                texturePath = "tiles/grass.png";
                break;
            case STONE:
                texturePath = "tiles/stone.png";
        }

        sprite = new Sprite(new Texture(texturePath));
        sprite.setPosition(position.x, position.y);
        sprite.setSize(MapGenerator.TILE_WIDTH,MapGenerator.TILE_HEIGHT);
    }

    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }
}
