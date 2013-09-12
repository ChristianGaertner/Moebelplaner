package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.input.Mouse;
import io.github.christiangaertner.moebelplaner.moebel.AbstractMoebel;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Grid implements IRenderable, IUpdateable {

    /**
     * Die Sprite der Grid
     */ 
    protected Sprite sprite;
    
    /**
     * Die Position wird immer 0, 0 sein.
     * Es ist nicht "final", da man so evtl. die Grid noch verschieben kann
     */
    protected int x, y;
    
    /**
     * Der MouseListener.
     * Genutzt, um Möbel zu verschieben
     */
    protected Mouse mouse;
    
    /**
     * Alle Entities (außer Möbel)
     */
    protected List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    
    protected List<AbstractMoebel> moebel = new ArrayList<AbstractMoebel>();

    public Grid(Mouse mouse) {
        this();
        this.mouse = mouse;
    }
    
    public Grid() {
        x = 0;
        y = 0;
        sprite = new Sprite("/images/grid.png");
    }

    /**
     * Fügt eine neue Entity der Grid hinzu.
     * @param e 
     */
    public void add(AbstractEntity e) {
        entities.add(e);
    }
    
    /**
     * Fügt ein neues Möbelstück der Grid hinzu.
     * @param e 
     */
    public void add(AbstractMoebel e) {
        moebel.add(e);
    }

    /**
     * Rendered diese Grid und alle sich
     * darauf befindenden Entities.
     * @param renderer 
     */
    @Override
    public void render(Renderer renderer) {
        // Erstmal die Grid selber rendern
        renderer.render(this, x, y);
        
        // Dann alle Möbel
        for (AbstractMoebel e : moebel) {
            e.render(renderer);
        }
        
        // Und ganz oben drauf die restlichen Entities
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
        // Alle Möbel & Entities updaten
        for (AbstractMoebel e : moebel) {
            e.update();
        }
        
        for (AbstractEntity e : entities) {
            e.update();
        }
    }
    
    public void clearAll() {
        entities.clear();
        moebel.clear();
    }
    
    public int entityCount() {
        return entities.size() + moebel.size();
    }
}
