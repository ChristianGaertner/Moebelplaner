package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.input.Mouse;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
     * Die Position wird immer 0, 0 sein. Es ist nicht "final", da man so evtl. die Grid noch verschieben kann
     */
    protected int x, y;
    /**
     * Der MouseListener. Genutzt, um Möbel zu verschieben
     */
    protected Mouse mouse;
    /**
     * Die Moebelplaner Instanz
     */
    protected Moebelplaner planer;
    /**
     * Alle Entities
     */
    protected List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    /**
     * Die gerade "markierten" Entities
     */
    protected List<AbstractEntity> focus = new ArrayList<AbstractEntity>();

    public Grid(Moebelplaner planer, Mouse mouse) {
        this();
        this.mouse = mouse;
        this.planer = planer;
    }

    public Grid() {
        x = 0;
        y = 0;
        sprite = new Sprite("/images/grid.png");
    }

    /**
     * Fügt eine neue Entity der Grid hinzu.
     *
     * @param e
     */
    public void add(AbstractEntity e) {
        entities.add(e);
    }
    
    /**
     * Löscht eine Entity
     * @param e 
     */
    public void delete(AbstractEntity e) {
        entities.remove(e);
    }

    /**
     * Rendered diese Grid und alle sich darauf befindenden Entities.
     *
     * @param renderer
     */
    @Override
    public void render(Renderer renderer) {
        // Erstmal die Grid selber rendern
        renderer.render(this, x, y);


        // dann alle Entites
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

        if (mouse.hold() == 1) {
            AbstractEntity e = getEntity(mouse.x(), mouse.y());
            if (e == null) {
                unFocusAll();
            } else {
                focus(e);
            }
        }

        if (mouse.hold() == 2) {
            for (AbstractEntity e : focus) {
                delete(e);
            }
        }

        // Alle Entities updaten       
        for (AbstractEntity e : entities) {
            e.update();
        }
    }

    /**
     * Löscht alle Entities. In folgenden Listen: entities, focus
     */
    public void clearAll() {
        entities.clear();
        focus.clear();
    }

    public int entityCount() {
        return entities.size();
    }

    public int focusCount() {
        return focus.size();
    }

    private void focus(AbstractEntity e) {
        if (!focus.contains(e)) {
            focus.add(e);
            e.focus();
        }
    }
    
    private void unFocus(AbstractEntity e) {
        focus.remove(e);
        e.unFocus();
    }
    
    private void unFocusAll() {
        for (Iterator<AbstractEntity> it = focus.iterator(); it.hasNext();) {
            unFocus(it.next());
        }
    }


    /**
     * Gibt die Entity an einer bestimmten Koordiante zurück
     *
     * @param x
     * @param y
     * @return
     */
    private AbstractEntity getEntity(int x, int y) {
        Shape bounds;
        for (AbstractEntity e : entities) {
            bounds = e.getBoundaries().getBounds();
            if (bounds.contains(x, y)) {
                return e;
            }

        }
        return null;
    }

    @Override
    public Shape getBoundaries() {
        return new Rectangle2D.Double(0, 0, sprite.getWidth(), sprite.getHeight());
    }
}
