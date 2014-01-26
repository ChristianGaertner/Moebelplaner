package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Badewanne extends AbstractMoebel {

    /**
     * Neue Badewanne von Bild "bett.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Badewanne(int x, int y) {
        super(x, y, "/images/moebel/badewanne.png");
    }

    /**
     * Neue Badewann an (0/0)
     */
    public Badewanne() {
        this(0, 0);
    }
}
