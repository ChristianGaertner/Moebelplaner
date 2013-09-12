package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Grid implements IRenderable {
    
    protected Sprite sprite;
    
    protected int x, y;

    
    public Grid() {
        x = 0;
        y = 0;
        sprite = Sprite.GRID;
    }
    
    
    @Override
    public void render(Renderer renderer) {
        renderer.render(this, x, y);
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
}
