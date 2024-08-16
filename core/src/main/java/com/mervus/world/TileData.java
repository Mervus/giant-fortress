package com.mervus.world;

import com.mervus.entity.Entity;

public class TileData {
    public Tile tile;
    public Entity entity;

    public TileData(Tile tile)
    {
        this.tile = tile;
    }

    public void addEntity(Entity entity)
    {
        this.entity = entity;
    }
}
