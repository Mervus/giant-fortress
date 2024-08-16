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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mervus.entity.Dwarf;
import com.mervus.entity.Elf;
import com.mervus.entity.Entity;
import com.mervus.world.MapGenerator;
import com.mervus.world.Tile;
import com.mervus.world.TileData;

import java.util.ArrayList;
import java.util.HashMap;

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
    Stage stage;
    public final static float WIDTH = 500;
    public final static float HEIGHT = 16 * WIDTH / 9;

    private FitViewport viewport;
    public OrthographicCamera camera;
    Tile[] tiles;
    ArrayList<Entity> entities;
    public HashMap<Vector2, TileData> mapData;

    @Override
    public void create() {
        camera = new OrthographicCamera(50, 50);
        viewport = new FitViewport(1440, 1080, camera);
        batch = new SpriteBatch();
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);

        mapData = new HashMap<Vector2, TileData>();
        tiles = MapGenerator.generateTiles(mapData);
        mapData.forEach((i, o) -> {
            stage.addActor(o.tile);
        });
        entities = new ArrayList<Entity>();
        Elf elf = new Elf(new Vector2(0,0));
        entities.add(elf);
        stage.addActor(elf);
        mapData.get(elf.position).entity = elf;
        //entities.add(new Dwarf(new Vector2(115,0)));
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        stage.act(delta);
        stage.draw();
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
