package com.mervus.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mervus.Main;
import com.mervus.world.MapGenerator;
import com.mervus.world.TileData;

public class Entity {
    public Vector2 position;
    Texture texture;
    Sprite sprite;
    boolean isMoving;

    public Entity(String texturePath, Vector2 position)
    {
        texture = new Texture(texturePath);
        sprite = new Sprite(texture);
        sprite.setPosition(position.x, position.y);
        isMoving = false;

        this.position = position;
    }

    /**
     *
     * @param direction Vector 0 - 1
     */
    public void move(Vector2 direction)
    {
        position.add(direction.x * MapGenerator.TILE_WIDTH, direction.y * MapGenerator.TILE_HEIGHT);

        TileData tileData = Main.getInstance().mapData.get(position);
        if (tileData != null)
        {
            tileData.entity = this;
        }
        sprite.setPosition(position.x, position.y);

        isMoving = false;
    }

    public void move(int x, int y)
    {
        move(new Vector2(x, y));
    }

    public void render(SpriteBatch batch)
    {
        update();
        sprite.draw(batch);
    }

    private void update()
    {
        boolean isPressed = Gdx.input.isKeyJustPressed(Input.Keys.A);
        if (isPressed && !isMoving)
        {
            isMoving = true;
            move(1, 0);
        }


    }
}
