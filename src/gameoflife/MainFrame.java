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
    Point selectionStart
         ,selectionEnd
         ,selectionSize;
    
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
        
        grid = new DrawableGrid(200, 200, new GridShape.Basic(), new GridCell.DrawableSquare());
        grid.scale = this.jSliderScale.getValue();

        Random rand = new Random(19580427);
        for(int x = 0; x < grid.maxWidth(); x++)
            for(int y = 0; y < grid.maxHeight(); y++)
                if(rand.nextInt(2) == 1)
                    grid.grid[x][y] = 1;
       
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
                
                if(selectionSize != null && selectionEnd != null && e.isShiftDown()) {
                    int width = (int)selectionSize.getX();
                    int height = (int)selectionSize.getY();
                    selectionEnd.setLocation(e.getX() + width, e.getY() + height);
                    selectionStart.setLocation(e.getX(), e.getY());
                }
                else {
                    selectionEnd = new Point(e.getX(), e.getY());
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
                selectionStart = selectionEnd = selectionSize = null;
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
        
        setViewSize();
        this.jScrollPane1.setViewportView(gridView);
    }

    void setUpdateGridTimerFrequency() {
        int delay = (int)(1000.0 / this.jSliderFrequency.getValue());
        this.updateGridTimer.setDelay(delay);
    }
    
    void setViewSize() {
        Dimension d = new Dimension(grid.maxWidth() * (int)grid.scale, grid.maxHeight() * (int)grid.scale);
        gridView.setSize(d);
        gridView.setPreferredSize(d);
        this.jScrollPane1.setPreferredSize(gridView.getPreferredSize());
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
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jSliderFrequency.setMaximum(20);
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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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
                grid.cellProfile = new GridCell.DrawableSquare();
                break;
            case "Triangle":
                grid.cellProfile = new GridCell.DrawableTriangle();
                break;
            case "Hexagon":
                grid.cellProfile = new GridCell.DrawableHexagon();
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
                grid.gridProfile = new GridShape.Basic();
                break;
            case "Cube":
                grid.gridProfile = new GridShape.Cube();
                break;
            case "Ring":
                grid.gridProfile = new GridShape.Ring();
                break;
            case "Sphere":
                grid.gridProfile = new GridShape.Sphere();
                break;
        }
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jComboBoxGridShapeItemStateChanged

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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderFrequency;
    private javax.swing.JSlider jSliderScale;
    // End of variables declaration//GEN-END:variables
}
