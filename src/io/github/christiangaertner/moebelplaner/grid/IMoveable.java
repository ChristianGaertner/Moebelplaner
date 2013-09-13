package io.github.christiangaertner.moebelplaner.grid;

/**
 *
 * @author Christian
 */
public interface IMoveable {

    /**
     * Relativ. Genutzt des Objekt zu "offsetten". Nicht absolut!
     *
     * @param x
     * @param y
     */
    public void move(int x, int y);

    /**
     * Absolut. Verändere die Position eines Objektes.
     *
     * @param x
     * @param y
     */
    public void moveTo(int x, int y);
}
