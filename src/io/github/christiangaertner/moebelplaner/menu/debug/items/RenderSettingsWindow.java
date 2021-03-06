package io.github.christiangaertner.moebelplaner.menu.debug.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;

/**
 *
 * @author Christian
 */
public class RenderSettingsWindow extends javax.swing.JPanel {

    private final Moebelplaner planer;
    private final Grid grid;

    /**
     * Creates new form TMP
     */
    public RenderSettingsWindow(Moebelplaner p, Grid g) {
        planer = p;
        grid = g;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bg = new javax.swing.JToggleButton();
        entites = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        hud = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        highlights = new javax.swing.JToggleButton();

        setLayout(new java.awt.GridBagLayout());

        bg.setSelected(grid.renderSettings("Background"));
        bg.setText("Background");
        bg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 144, 0, 0);
        add(bg, gridBagConstraints);

        entites.setSelected(grid.renderSettings("Entity"));
        entites.setText("Entities");
        entites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entitesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 144, 0, 0);
        add(entites, gridBagConstraints);

        jLabel1.setText("Toogle Rendering");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 152, 0, 0);
        add(jLabel1, gridBagConstraints);

        hud.setText("Toogle HUD");
        hud.setAlignmentX(20.0F);
        hud.setAlignmentY(500.0F);
        hud.setContentAreaFilled(false);
        hud.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        hud.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        hud.setLocation(new java.awt.Point(5, 200));
        hud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hudActionPerformed(evt);
            }
        });
        add(hud, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel3.setText("RenderSettings");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 80, 0, 73);
        add(jLabel3, gridBagConstraints);

        highlights.setSelected(grid.renderSettings("Highlight"));
        highlights.setText("Highlights");
        highlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highlightsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 144, 104, 0);
        add(highlights, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgActionPerformed
        grid.renderSettings("Background", !grid.renderSettings("Background"));
    }//GEN-LAST:event_bgActionPerformed

    private void entitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entitesActionPerformed
        grid.renderSettings("Entity", !grid.renderSettings("Entity"));
    }//GEN-LAST:event_entitesActionPerformed

    private void hudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hudActionPerformed
        planer.toogleHud();
    }//GEN-LAST:event_hudActionPerformed

    private void highlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highlightsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highlightsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bg;
    private javax.swing.JToggleButton entites;
    private javax.swing.JToggleButton highlights;
    private javax.swing.JToggleButton hud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
