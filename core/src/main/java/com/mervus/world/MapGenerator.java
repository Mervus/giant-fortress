package com.mervus.world;

public class MapGenerator {
    public static int TILE_WIDTH = 10;
    public static int TILE_HEIGHT = 10;

    public static Tile[] generateTiles() {
        Tile[] tiles = new Tile[10 * 10];

        int tileCount = 0;
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                tiles[tileCount] = new Tile(-50 + (x * TILE_WIDTH), -50 + y * TILE_HEIGHT, tileCount);
                tileCount++;
            }
        }

        System.out.println(tileCount);
        return tiles;
    }
}
