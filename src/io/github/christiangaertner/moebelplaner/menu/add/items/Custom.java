package io.github.christiangaertner.moebelplaner.menu.add.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.moebel.AbstractMoebel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 *
 * @author Christian
 */
public class Custom extends JMenuItem {

    public Custom(Moebelplaner planer, final Grid grid) {
        super("Custom");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFrame guiFrame = new JFrame();
                JFileChooser fileDialog = new JFileChooser();

                if (fileDialog.showOpenDialog(guiFrame) == JFileChooser.APPROVE_OPTION) {

                    File selectedFile = fileDialog.getSelectedFile();

                    String mimetype = new MimetypesFileTypeMap().getContentType(selectedFile);

                    String type = mimetype.split("/")[0];

                    if (type.contains("image")) {
                        grid.add(new AbstractMoebel(selectedFile.getAbsolutePath(), true) {
                        });
                    } else {
                        Moebelplaner.LOGGER.log(Level.INFO, "Nur Bilder sind unterstützt");
                    }


                }

            }
        });
    }
}
