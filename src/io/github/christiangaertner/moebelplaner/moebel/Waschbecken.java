package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Waschbecken extends AbstractMoebel {

    /**
     * Neues Waschbecken von Bild "toilette.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Waschbecken(int x, int y) {
        super("/images/moebel/waschbecken.png");
        this.x = x;
        this.y = y;
    }

    /**
     * Neue Toilette an (0/0)
     */
    public Waschbecken() {
        this(0, 0);
    }
}
