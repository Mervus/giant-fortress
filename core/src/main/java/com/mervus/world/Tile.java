package com.mervus.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tile extends Actor {
    Sprite sprite;
    Vector2 position;
    boolean isWalkable;
    TileType tileType;

    public Tile(Vector2 position, TileType tileType)
    {
        this.position = position;
        String texturePath = null;
        this.tileType = tileType;
        switch (tileType)
        {
            case GRASS:
                texturePath = "tiles/grass.png";
                break;
            case STONE:
                texturePath = "tiles/stone.png";
                break;
            case TREE:
                texturePath = "tiles/tree.png";
        }
        this.setWidth(MapGenerator.TILE_WIDTH);
        this.setHeight(MapGenerator.TILE_HEIGHT);

        sprite = new Sprite(new Texture(texturePath));
        sprite.setPosition(position.x, position.y);
        sprite.setSize(MapGenerator.TILE_WIDTH,MapGenerator.TILE_HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

}
