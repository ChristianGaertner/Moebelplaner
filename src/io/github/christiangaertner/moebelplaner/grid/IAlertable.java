package io.github.christiangaertner.moebelplaner.grid;

/**
 *
 * @author Christian
 */
public interface IAlertable {
    /**
     * Alamiert ein Objekt
     */ 
    public void alert();
    
    /**
     * Bringt es zurück in den normalen zu Stand
     */
    public void unAlert();
    
    /**
     * Gibt zurück, ob das Objekt gerade alamiert ist
     */
    public boolean isAlerted();
}
