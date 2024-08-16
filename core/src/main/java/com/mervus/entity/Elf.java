package com.mervus.entity;

import com.badlogic.gdx.math.Vector2;

public class Elf extends Entity{
    public Elf(Vector2 position) {
        super("animals/elfs/elf.png", position);
        sprite.setCenter(16, 32);
    }

}
