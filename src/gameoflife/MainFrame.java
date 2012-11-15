/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Christiaan
 */
public class MainFrame extends javax.swing.JFrame {

    DrawableGrid grid;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        grid = new DrawableGrid(100, 100, new GridShape.Basic(), new GridCell.Square());

        grid.grid[10][10] = 1;
        grid.grid[11][10] = 1;
        grid.grid[12][10] = 1;
        
        grid.grid[23][10] = 1;
        grid.grid[24][10] = 1;
        grid.grid[25][10] = 1;
        
        grid.grid[10][21] = 1;
        grid.grid[11][21] = 1;
        grid.grid[12][21] = 1;
        grid.grid[13][31] = 1;
        grid.grid[14][31] = 1;
        grid.grid[15][31] = 1;
        
        grid.grid[60][10] = 1;
        grid.grid[61][10] = 1;
        grid.grid[61][11] = 1;
        grid.grid[60][11] = 1;
        
        grid.grid[62][12] = 1;
        grid.grid[63][12] = 1;
        grid.grid[63][13] = 1;
        grid.grid[62][13] = 1;
        
        Random rand = new Random(19580427);
        for(int x = 10; x < grid.maxWidth(); x++)
            for(int y = 10; y < grid.maxHeight(); y++)
                if(rand.nextInt(30) == 1)
                    grid.grid[x][y] = 1;
        
        JPanel foobar = new JPanel() {
                public void paintComponent( Graphics g ) {
                   super.paintComponent(g);
                   grid.Draw(g);
                   /*
                   double scale = (double)(jSliderScale.getValue() + 1) / 100.0;

                   Line2D line = new Line2D.Double(10 * scale, 10 * scale, 40 * scale, 40 * scale);
                   g2.setColor(Color.blue);
                   g2.setStroke(new BasicStroke((int)(10 * scale)));
                   g2.draw(line);

                   g2.setColor(Color.orange);
                   g2.drawOval((int)(10 * scale), (int)(10 * scale), (int)(100 * scale), (int)(100 * scale));
                   g2.setColor(Color.LIGHT_GRAY);
                   g2.drawOval((int)(40 * scale), (int)(100 * scale), (int)(100 * scale), (int)(100 * scale));
                   g2.setColor(Color.PINK);
                   g2.drawOval((int)(40 * scale), (int)(500 * scale), (int)(100 * scale), (int)(100 * scale));
                   */
                }
           };
        //foobar.setBackground(Color.red);
        foobar.setPreferredSize(new Dimension(4000, 4000));
        this.jScrollPane1.setViewportView(foobar);
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
        jSlider1 = new javax.swing.JSlider();
        jSliderScale = new javax.swing.JSlider();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jSliderScale.setMaximum(99);
        jSliderScale.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderScale.setValue(100);
        jSliderScale.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderScaleStateChanged(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSliderScale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderScale, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderScaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderScaleStateChanged
        // TODO add your handling code here:
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jSliderScaleStateChanged

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        System.out.println(evt.getX() + "," + evt.getY());
        System.out.println(evt.getX() + this.jScrollPane1.getVerticalScrollBar().getAlignmentX() + "," + evt.getY() + this.jScrollPane1.getVerticalScrollBar().getAlignmentY());
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        grid.Update();
        this.jScrollPane1.repaint();
    }//GEN-LAST:event_jButton1MouseClicked

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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSliderScale;
    // End of variables declaration//GEN-END:variables
}
