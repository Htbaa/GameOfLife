/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Christiaan
 */
public class MainFrame extends javax.swing.JFrame {

    DrawableGrid grid;
    Timer updateGridTimer;
    JPanel gridView;
    Point selectionStart,gridSelectionStart
         ,selectionEnd,gridSelectionEnd
         ,selectionSize;
    private Random rand = new Random(19580427);
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        ActionListener updateGrid = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(grid != null) {
                    grid.Update();
                    jScrollPane1.repaint();
                }
            }
        };
        updateGridTimer = new Timer(1000, updateGrid);
        this.setUpdateGridTimerFrequency();
        
        try {
            grid = new DrawableGrid(200, 200, new GridShape.Basic(), new GridCell.DrawableSquare());
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            this.dispose();
            return;
        }
        grid.scale = this.jSliderScale.getValue();

        randomizeGrid();

        prepareGridView();
        setViewSize();
        this.jScrollPane1.setViewportView(gridView);
    }
    
    /**
     * Reset grid and randomly fill it
     */
    private void randomizeGrid() {
        grid.Reset();
        for(int x = 0; x < grid.maxWidth(); x++)
            for(int y = 0; y < grid.maxHeight(); y++)
                if(rand.nextInt(2) == 1)
                    grid.grid[x][y] = 1;
    }

    /**
     * Adds and prepares the drawable JPanel on which the grid will be drawn
     */
    void prepareGridView() {
        gridView = new JPanel() {
                public void paintComponent( Graphics g ) {
                   super.paintComponent(g);
                   grid.Draw(g);
                   
                   if(selectionStart != null && selectionSize != null) {
                       Graphics2D g2 = (Graphics2D)g;
                       g2.setColor(Color.orange);
                       Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f);
                       g2.setComposite(c);
                       int startX = (int)selectionStart.getX();
                       int startY = (int)selectionStart.getY();
                       int width = (int)selectionSize.getX();
                       int height = (int)selectionSize.getY();
                       g2.drawRect(startX, startY, width, height);
                       g2.fillRect(startX, startY, width, height);
                   }
                }
           };

        gridView.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectionStart == null)
                    selectionStart = new Point(e.getX(), e.getY());
                
                if(gridSelectionStart == null)
                    gridSelectionStart = new Point(e.getX(), e.getY());
                
                if(selectionSize != null && selectionEnd != null && e.isShiftDown()) {
                    int x1 = (int)(gridSelectionStart.getX() / grid.scale);
                    int y1 = (int)(gridSelectionStart.getY() / grid.scale);
                    int x2 = (int)(gridSelectionEnd.getX() / grid.scale);
                    int y2 = (int)(gridSelectionEnd.getY() / grid.scale);
                    
                    int width = selectionSize.x;
                    int height = selectionSize.y;
                    selectionEnd.setLocation(e.getX() + width, e.getY() + height);
                    selectionStart.setLocation(e.getX(), e.getY());
                    if(e.isAltDown())
                        grid.CopyCells(x1, y1, x2, y2, (int)(selectionStart.x / grid.scale), (int)(selectionStart.y / grid.scale));
                }
                else {
                    selectionEnd = new Point(e.getX(), e.getY());
                    gridSelectionEnd = new Point(e.getX(), e.getY());
                    int startX = (int)selectionStart.getX();
                    int startY = (int)selectionStart.getY();
                    int width = (int)selectionEnd.getX() - startX;
                    int height = (int)selectionEnd.getY() - startY;
                    selectionSize = new Point(width, height);
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        
        gridView.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectionStart = selectionEnd = selectionSize
                        = gridSelectionStart = gridSelectionEnd = null;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    
    /**
     * Update frequency of the timer that periodically updates the grid
     */
    void setUpdateGridTimerFrequency() {
        int delay = (int)(1000.0 / this.jSliderFrequency.getValue());
        this.updateGridTimer.setDelay(delay);
    }
    
    /**
     * Resize scrollbars of drawable area
     */
    void setViewSize() {
        Dimension d = new Dimension(grid.maxWidth() * (int)grid.scale, grid.maxHeight() * (int)grid.scale);
        gridView.setSize(d);
        gridView.setPreferredSize(d);
        this.jScrollPane1.setPreferredSize(gridView.getPreferredSize());
    }
    
    private void DrawFigure(int[][] positions) {
        grid.Reset();
        grid.PopulateCells(positions);
        this.jScrollPane1.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jSliderFrequency = new javax.swing.JSlider();
        jSliderScale = new javax.swing.JSlider();
        jComboBoxGridCell = new javax.swing.JComboBox();
        jButtonStartStop = new javax.swing.JButton();
        jComboBoxGridShape = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemFigureMountingBlock = new javax.swing.JMenuItem();
        jMenuItemFigureGliderBomb = new javax.swing.JMenuItem();
        jMenuItemFigureArch = new javax.swing.JMenuItem();
        jMenuItemFigureSpaceship = new javax.swing.JMenuItem();
        jMenuItemFigureExplosion = new javax.swing.JMenuItem();
        jMenuItemFigureLongLine = new javax.swing.JMenuItem();
        jMenuItemFigureRandomize = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jSliderFrequency.setMaximum(200);
        jSliderFrequency.setMinimum(1);
        jSliderFrequency.setValue(10);
        jSliderFrequency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderFrequencyStateChanged(evt);
            }
        });

        jSliderScale.setMaximum(50);
        jSliderScale.setMinimum(1);
        jSliderScale.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderScale.setValue(10);
        jSliderScale.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderScaleStateChanged(evt);
            }
        });

        jComboBoxGridCell.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Square", "Triangle", "Hexagon" }));
        jComboBoxGridCell.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxGridCellItemStateChanged(evt);
            }
        });

        jButtonStartStop.setText("Start");
        jButtonStartStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartStopMouseClicked(evt);
            }
        });

        jComboBoxGridShape.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basic", "Cube", "Ring", "Sphere" }));
        jComboBoxGridShape.setToolTipText("");
        jComboBoxGridShape.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxGridShapeItemStateChanged(evt);
            }
        });

        jMenu1.setText("Figures");

        jMenuItemFigureMountingBlock.setText("Mounting Block");
        jMenuItemFigureMountingBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureMountingBlockActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureMountingBlock);

        jMenuItemFigureGliderBomb.setText("Glider Bomb");
        jMenuItemFigureGliderBomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureGliderBombActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureGliderBomb);

        jMenuItemFigureArch.setText("Arch");
        jMenuItemFigureArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureArchActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureArch);

        jMenuItemFigureSpaceship.setText("Spaceship");
        jMenuItemFigureSpaceship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureSpaceshipActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureSpaceship);

        jMenuItemFigureExplosion.setText("Explosion");
        jMenuItemFigureExplosion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureExplosionActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureExplosion);

        jMenuItemFigureLongLine.setText("Long Line");
        jMenuItemFigureLongLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureLongLineActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureLongLine);

        jMenuItemFigureRandomize.setText("Randomize");
        jMenuItemFigureRandomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFigureRandomizeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFigureRandomize);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSliderFrequency, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSliderScale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonStartStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxGridShape, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxGridCell, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderScale, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jSliderFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxGridCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxGridShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStartStop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderScaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderScaleStateChanged
        this.grid.SetScale((double)this.jSliderScale.getValue());
        this.setViewSize();
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jSliderScaleStateChanged

    private void jButtonStartStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartStopMouseClicked
        switch(this.jButtonStartStop.getText()) {
            default:
            case "Start":
                this.updateGridTimer.start();
                this.jButtonStartStop.setText("Stop");
                break;
            case "Stop":
                this.updateGridTimer.stop();
                this.jButtonStartStop.setText("Start");
                break;
        }
    }//GEN-LAST:event_jButtonStartStopMouseClicked

    private void jComboBoxGridCellItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxGridCellItemStateChanged
        switch(jComboBoxGridCell.getSelectedItem().toString()) {
            default:
            case "Square":
                grid.setCellProfile(new GridCell.DrawableSquare());
                break;
            case "Triangle":
                grid.setCellProfile(new GridCell.DrawableTriangle());
                break;
            case "Hexagon":
                grid.setCellProfile(new GridCell.DrawableHexagon());
                break;
        }
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jComboBoxGridCellItemStateChanged

    private void jSliderFrequencyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderFrequencyStateChanged
        this.setUpdateGridTimerFrequency();
    }//GEN-LAST:event_jSliderFrequencyStateChanged

    private void jComboBoxGridShapeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxGridShapeItemStateChanged
        switch(jComboBoxGridShape.getSelectedItem().toString()) {
            default:
            case "Basic":
                grid.setGridProfile(new GridShape.Basic());
                break;
            case "Cube":
                grid.setGridProfile(new GridShape.Cube());
                break;
            case "Ring":
                grid.setGridProfile(new GridShape.Ring());
                break;
            case "Sphere":
                grid.setGridProfile(new GridShape.Sphere());
                break;
        }
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jComboBoxGridShapeItemStateChanged

    private void jMenuItemFigureMountingBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureMountingBlockActionPerformed
        int[][] positions = new int[][] {
            new int[] {101,100},
            new int[] {100,101}, new int[] {101,101}, new int[] {102,101},
            new int[] {100,102}, new int[] {102,102}, new int[] {103,102},
        };
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureMountingBlockActionPerformed

    private void jMenuItemFigureGliderBombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureGliderBombActionPerformed
        int[][] positions = new int[][] {
            new int[] {102,100}, new int[] {103,100}, new int[] {105,100}, new int[] {106,100},
            new int[] {101,101}, new int[] {103,101}, new int[] {105,101}, new int[] {107,101},
            new int[] {100,102}, new int[] {101,102}, new int[] {103,102}, new int[] {105,102}, new int[] {107,102}, new int[] {108,102},
            new int[] {101,103}, new int[] {103,103}, new int[] {105,103}, new int[] {107,103},
            new int[] {102,104}, new int[] {103,104}, new int[] {105,104}, new int[] {106,104},
        };
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureGliderBombActionPerformed

    private void jMenuItemFigureArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureArchActionPerformed
        int[][] positions = new int[][] {
            new int[] {100,100}, new int[] {101,100}, new int[] {102,100},
            new int[] {100,101}, new int[] {102,101},
            new int[] {100,102}, new int[] {102,102},
        };
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureArchActionPerformed

    private void jMenuItemFigureSpaceshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureSpaceshipActionPerformed
        int[][] positions = new int[][] {
            new int[] {103,100},
            new int[] {104,101},
            new int[] {100,102}, new int[] {104,102},
            new int[] {101,103}, new int[] {102,103}, new int[] {103,103}, new int[] {104,103},
        };
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureSpaceshipActionPerformed

    private void jMenuItemFigureExplosionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureExplosionActionPerformed
        int[][] positions = new int[][] {
            new int[] {101,100}, new int[] {102,100},
            new int[] {100,101}, new int[] {101,101},
            new int[] {101,102},
        };
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureExplosionActionPerformed

    private void jMenuItemFigureLongLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureLongLineActionPerformed
        int[][] positions = new int[grid.maxWidth()][2];
        int quarter = positions.length / 4;
        for(int x = 0; x < positions.length - quarter; x++) {
            positions[x] = new int[]{x,120};
        }
        for(int x = positions.length - quarter; x < positions.length; x++) {
            positions[x] = new int[]{x,100};
        }
        DrawFigure(positions);
    }//GEN-LAST:event_jMenuItemFigureLongLineActionPerformed

    private void jMenuItemFigureRandomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFigureRandomizeActionPerformed
        randomizeGrid();
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jMenuItemFigureRandomizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStartStop;
    private javax.swing.JComboBox jComboBoxGridCell;
    private javax.swing.JComboBox jComboBoxGridShape;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemFigureArch;
    private javax.swing.JMenuItem jMenuItemFigureExplosion;
    private javax.swing.JMenuItem jMenuItemFigureGliderBomb;
    private javax.swing.JMenuItem jMenuItemFigureLongLine;
    private javax.swing.JMenuItem jMenuItemFigureMountingBlock;
    private javax.swing.JMenuItem jMenuItemFigureRandomize;
    private javax.swing.JMenuItem jMenuItemFigureSpaceship;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderFrequency;
    private javax.swing.JSlider jSliderScale;
    // End of variables declaration//GEN-END:variables
}
