package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Sofa extends AbstractMoebel {

    /**
     * Neues Sofa von Bild "toilette.png"
     *
     * @param x Die X-Koordinate
     * @param y Die Y-Koordinate
     */
    public Sofa(int x, int y) {
        super(x, y, "/images/moebel/sofa.png");
    }
    
    /**
     * Neues Sofa an (0/0)
     */
    public Sofa() {
        this(0, 0);
    }
}
