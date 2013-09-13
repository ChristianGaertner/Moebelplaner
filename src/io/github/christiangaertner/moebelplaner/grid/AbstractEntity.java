package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Christian
 */
abstract public class AbstractEntity implements IRenderable, IUpdateable {

    /**
     * Die Sprite für dieses Möbelstück
     */
    protected Sprite sprite;
    /**
     * Die X-Y Koordinate auf der Grid
     */
    protected int x, y;

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

    @Override
    public Shape getBounds() {
        return new Rectangle2D.Double(x, y, sprite.getWidth(), sprite.getHeight());
    }
}
