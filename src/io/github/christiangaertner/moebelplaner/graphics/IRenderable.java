package io.github.christiangaertner.moebelplaner.graphics;

import java.awt.Shape;

/**
 *
 * @author Christian
 */
public interface IRenderable {

    /**
     * Gibt einfach nur die Sprite zurück
     *
     * @return
     */
    public Sprite getSprite();

    /**
     * Die X-Koordinate auf der Grid
     *
     * @return
     */
    public int x();

    /**
     * Die X-Koordinate auf der Grid
     *
     * @return
     */
    public int y();

    /**
     * Gibt den Bereich wieder, der von der Entity genutzt wird
     *
     * @return
     */
    public Shape getBoundaries();
}
