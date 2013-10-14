package io.github.christiangaertner.moebelplaner.menu.add.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.moebel.AbstractMoebel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.JMenuItem;

/**
 *
 * @author Christian
 */
public class FurnitureItem extends JMenuItem {

    public FurnitureItem(String name, Moebelplaner planer, final Grid grid) {
        super(name);
        
        // Das ist etwas komisch aber ganz logisch!
        // Erstmal das jetzige package bekommen:
        // this.getClass().getPackage() -> io.github.christiangaertner.moebelplaner
        // Dann liegen alle Möbel im Möbel sub-package
        // .mobel.
        // Und jetzt noch den Klassennamen hinzufügen und schließlich noch die ersten 8 chars wegschneiden:
        // Die ersten 8 sind "package "
        final String fullClassName = "io.github.christiangaertner.moebelplaner.moebel." + name;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    grid.add((AbstractMoebel) Class.forName(fullClassName).newInstance());
                } catch (ClassNotFoundException ex) {
                    Moebelplaner.LOGGER.log(Level.SEVERE, "Klasse nicht gefunden", ex);
                } catch (InstantiationException ex) {
                    Moebelplaner.LOGGER.log(Level.SEVERE, "Neues Objekt konnte nicht erstellt werden", ex);
                } catch (IllegalAccessException ex) {
                    Moebelplaner.LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
}
