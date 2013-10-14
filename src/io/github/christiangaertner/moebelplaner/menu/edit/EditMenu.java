package io.github.christiangaertner.moebelplaner.menu.edit;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.menu.edit.items.Delete;
import io.github.christiangaertner.moebelplaner.menu.edit.items.SelectAll;
import javax.swing.JMenu;

/**
 *
 * @author Christian
 */
public class EditMenu extends JMenu {

    public EditMenu(Moebelplaner planer, Grid grid) {
        super("Edit");
        add(new SelectAll(planer, grid));
        add(new Delete(planer, grid));
    }
}
