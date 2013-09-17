package io.github.christiangaertner.moebelplaner;

import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.moebel.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Christian
 */
public class MenuBar {

    private final Grid grid;
    private final Moebelplaner planer;
    private final List<String> furnities = new ArrayList<String>();

    public MenuBar(Moebelplaner p, Grid g) {
        grid = g;
        planer = p;

        furnities.add("Bett");
        furnities.add("Schreibtisch");
        furnities.add("Sofa");
        furnities.add("Toilette");
        furnities.add("Waschbecken");
        furnities.add("Badewanne");

    }

    public JMenuBar getMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        for (JMenu menu : getMenus()) {
            menuBar.add(menu);
        }





        return menuBar;
    }

    private List<JMenu> getMenus() {

        List<JMenu> menus = new ArrayList<JMenu>();


        JMenu edit = new JMenu("Edit");
        JMenu add = new JMenu("Add");

        for (JMenuItem i : getMenuItemsEdit()) {
            edit.add(i);
        }

        for (JMenuItem i : getMenuItemsAdd()) {
            add.add(i);
        }


        menus.add(edit);
        menus.add(add);

        return menus;
    }

    private List<JMenuItem> getMenuItemsEdit() {
        List<JMenuItem> items = new ArrayList<JMenuItem>();



        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.focus();
            }
        });


        JMenuItem delete = new JMenuItem("Delete");
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.deleteFocused();
            }
        });

        items.add(delete);
        items.add(selectAll);

        return items;
    }

    private List<JMenuItem> getMenuItemsAdd() {
        List<JMenuItem> items = new ArrayList<JMenuItem>();

        JMenuItem MoebelMenu = new JMenu("Furniture");

        for (String s : furnities) {
            MoebelMenu.add(createItem(s));
        }

        items.add(MoebelMenu);

        return items;
    }

    private JMenuItem createItem(String className) {

        // Das ist etwas komisch aber ganz logisch!
        // Erstmal das jetzige package bekommen:
        // this.getClass().getPackage() -> io.github.christiangaertner.moebelplaner
        // Dann liegen alle Möbel im Möbel sub-package
        // .mobel.
        // Und jetzt noch den Klassennamen hinzufügen und schließlich noch die ersten 8 chars wegschneiden:
        // Die ersten 8 sind "package "
        final String fullClassName = (this.getClass().getPackage() + ".moebel." + className).substring(8);

        JMenuItem item = new JMenuItem(className);

        item.addActionListener(new ActionListener() {
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

        return item;
    }
}
