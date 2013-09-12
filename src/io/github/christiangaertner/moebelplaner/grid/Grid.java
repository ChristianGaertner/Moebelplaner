package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Grid implements IRenderable, IUpdateable {
    
    protected Sprite sprite;
    
    protected int x, y;
    
    protected List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    
    public Grid() {
        x = 0;
        y = 0;
        sprite = new Sprite("/images/grid.png");
        
    }
    
    public void add(AbstractEntity e) {
        entities.add(e);
    }
    
    
    @Override
    public void render(Renderer renderer) {
        renderer.render(this, x, y);
        for (AbstractEntity e : entities) {
            e.render(renderer);
        }
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public void update() {
        for(AbstractEntity e : entities) {
            e.update();
        }
    }
}
