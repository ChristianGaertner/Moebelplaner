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
        super("/images/moebel/sofa.png");
        this.x = x;
        this.y = y;
    }
    
    /**
     * Neues Sofa an (0/0)
     */
    public Sofa() {
        this(0, 0);
    }
}
