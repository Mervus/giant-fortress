package com.mervus.world;

import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class MapGenerator {
    public static int TILE_WIDTH = 40;
    public static int TILE_HEIGHT = 40;

    public static Tile[] generateTiles(HashMap<Vector2, TileData> mapData) {
        int dim = 50;
        Tile[] tiles = new Tile[dim * dim];


        int tileCount = 0;
        for (int y = 0; y < dim; y++) {
            for (int x = 0; x < dim; x++) {
                Vector2 pos = new Vector2((x * TILE_WIDTH), (y * TILE_HEIGHT));
                tiles[tileCount] = new Tile(pos, tileCount);
                mapData.put(pos, new TileData(tiles[tileCount]));
                tileCount++;
            }
        }

        System.out.println(tileCount);
        return tiles;
    }
}
