package com.mervus.world;

import com.badlogic.gdx.math.Vector2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MapGenerator {
    public static int TILE_WIDTH = 40;
    public static int TILE_HEIGHT = 40;

    public static Tile[] generateTiles(HashMap<Vector2, TileData> mapData) {
        int dim = 50;
        Tile[] tiles = new Tile[dim * dim];
        BufferedImage noiseMap = loadNoise();

        int tileCount = 0;
        for (int y = 0; y < dim; y++) {
            for (int x = 0; x < dim; x++) {
                int howGrayIsIt = getGrayscaleValue(noiseMap, x, y);

                Vector2 pos = new Vector2((x * TILE_WIDTH), (y * TILE_HEIGHT));
                tiles[tileCount] = new Tile(pos, getTileType(howGrayIsIt));
                mapData.put(pos, new TileData(tiles[tileCount]));
                tileCount++;
            }
        }


        System.out.println(tileCount);
        return tiles;
    }

    public static TileType getTileType(int value)
    {
        if (value > 118 && value < 123)
            return TileType.TREE;

        if (value > 145)
            return TileType.STONE;

        return TileType.GRASS;
    }

    public static BufferedImage loadNoise()
    {
        BufferedImage noiseMap = null;
        try {
            noiseMap = ImageIO.read(new File("assets/noiseTexture.png"));

            return noiseMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getGrayscaleValue(BufferedImage noise_map, int x, int y)
    {
        int rgb = noise_map.getRGB(x,y);

        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        int grayscale = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
        return grayscale;
    }
}
