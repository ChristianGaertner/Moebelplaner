package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Toilette extends AbstractMoebel {

    /**
     * Neue Toilette von Bild "toilette.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Toilette(int x, int y) {
        super(x, y, "/images/moebel/toilette.png");
    }

    /**
     * Neue Toilette an (0/0)
     */
    public Toilette() {
        this(0, 0);
    }
}
