package io.github.christiangaertner.moebelplaner.menu.add;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.menu.add.items.Custom;
import javax.swing.JMenu;

/**
 *
 * @author Christian
 */
public class AddMenu extends JMenu {

    public AddMenu(Moebelplaner planer, Grid grid) {
        super("Add");

        add(new AddFurnitureMenu(planer, grid));
        add(new Custom(planer, grid));
    }
}
