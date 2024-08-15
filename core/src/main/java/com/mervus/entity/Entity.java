package com.mervus.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
    int x,y;
    Texture texture;
    Sprite sprite;

    public Entity(String texturePath, int x, int y)
    {
        texture = new Texture(texturePath);
        sprite = new Sprite(texture);
        sprite.setPosition(10, 10);
        sprite.setRotation(45);
        this.x = x;
        this.y = y;
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture, 0, 0);
    }
}
