package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Bett extends AbstractMoebel {

    /**
     * Neues Bett von Bild "bett.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Bett(int x, int y) {
        super(x, y, "/images/moebel/bett.png");
    }

    /**
     * Neues Bett an (0/0)
     */
    public Bett() {
        this(0, 0);
    }
}
