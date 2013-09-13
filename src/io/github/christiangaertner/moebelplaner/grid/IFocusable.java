package io.github.christiangaertner.moebelplaner.grid;

/**
 *
 * @author Christian
 */
public interface IFocusable {

    /**
     * Wird aufgerufen, wenn ein Objekt fokussiert wird.
     */
    public void focus();

    /**
     * Wird aufgerufen, wenn der Fokus aufgehoben wird.
     */
    public void unFocus();
}
