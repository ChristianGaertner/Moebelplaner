package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Schrank extends AbstractMoebel {

    /**
     * Neuer Schrank von Bild "schrank.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Schrank(int x, int y) {
        super("/images/moebel/schrank.png");
        this.x = x;
        this.y = y;
    }

    /**
     * Neuer Schrank an (0/0)
     */
    public Schrank() {
        this(0, 0);
    }
}
