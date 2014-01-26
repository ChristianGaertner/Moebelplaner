package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Schreibtisch extends AbstractMoebel {

    /**
     * Neuer Schreibtisch von Bild "toilette.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Schreibtisch(int x, int y) {
        super(x, y, "/images/moebel/schreibtisch.png");
    }

    /**
     * Neuer Schreibtisch an (0/0)
     */
    public Schreibtisch() {
        this(0, 0);
    }
}
