package com.mervus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mervus.entity.Elf;
import com.mervus.world.MapGenerator;
import com.mervus.world.Tile;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private static Main INSTANCE;

    public Main() {
        INSTANCE = this;
    }

    public static Main getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Main();
        }

        return INSTANCE;
    }

    private SpriteBatch batch;
    private Rectangle bucket;
    private Texture bucketImage;
    public final static float WIDTH = 500;
    public final static float HEIGHT = 16 * WIDTH / 9;

    FitViewport viewport;
    public OrthographicCamera camera;
    Tile[] tiles;
    Elf elf;

    @Override
    public void create() {
        camera = new OrthographicCamera(50, 100);
        viewport = new FitViewport(50, 50, camera);
        batch = new SpriteBatch();
        tiles = MapGenerator.generateTiles();
        elf = new Elf(0, 0);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        batch.begin();
        for (int i = 0; i < tiles.length; i++) {
            tiles[i].render(batch);
        }
        batch.end();

        batch.begin();
        elf.render(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
