package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Bett extends AbstractMoebel {

    /**
     * Neuer Schrank von Bild "bett.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Bett(int x, int y) {
        super("/images/moebel/bett.png");
        this.x = x;
        this.y = y;
    }

    /**
     * Neuer Schrank an (0/0)
     */
    public Bett() {
        this(0, 0);
    }
}
