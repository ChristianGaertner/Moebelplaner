package io.github.christiangaertner.moebelplaner.menu.add;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.menu.add.items.FurnitureItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Christian
 */
public class AddFurnitureMenu extends JMenu {

    private List<JMenuItem> items = new ArrayList<JMenuItem>();
    
    public AddFurnitureMenu(Moebelplaner planer, Grid grid) {
        super("Furniture");

        add(new FurnitureItem("Bett", planer, grid));
        add(new FurnitureItem("Schreibtisch", planer, grid));
        add(new FurnitureItem("Sofa", planer, grid));
        add(new FurnitureItem("Toilette", planer, grid));
        add(new FurnitureItem("Waschbecken", planer, grid));
        add(new FurnitureItem("Badewanne", planer, grid));
        
    }
    
}
