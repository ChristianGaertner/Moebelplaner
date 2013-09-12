package io.github.christiangaertner.moebelplaner.moebel;

/**
 *
 * @author Christian
 */
public class Schrank extends AbstractMoebel {
    
    /**
     * Neuer Schrank vpn Bild "schrank.png"
     */ 
    public Schrank() {
        super("/images/moebel/schrank.png");
        x = 50;
        y = 60;
    }
    
    @Override
    public void update() {
    }
    
}
