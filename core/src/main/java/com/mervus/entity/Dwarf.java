package com.mervus.entity;

import com.badlogic.gdx.math.Vector2;

public class Dwarf extends Entity{
    public Dwarf(Vector2 position) {
        super("animals/dwarfs/dwarf.png", position);
        sprite.setScale(2.5f);
    }
}
