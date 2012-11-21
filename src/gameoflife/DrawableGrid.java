/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import GridShape.Profile;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Drawable implementation of Grid
 * @author Christiaan
 */
public class DrawableGrid extends Grid {

    /**
     * Drawing scale
     */
    double scale = 10.0;
    
    /**
     * Constructor
     * @param max_x Max number of columns
     * @param max_y Max number of rows
     * @param gridProfile GridShape.Profile to use
     * @param cellProfile GridCell.Profile to use
     * @throws Exception 
     */
    public DrawableGrid(int max_x, int max_y, Profile gridProfile, GridCell.Profile cellProfile) throws Exception {
        super(max_x, max_y, gridProfile, cellProfile);
        if(!(cellProfile instanceof GridCell.Drawable))
            throw new Exception("cellProfile should implement GridCell.Drawable interface");
    }

    /**
     * Draws the grid using the provided Graphics object
     * @param g 
     */
    public void Draw(Graphics g) {
        int gridWidth = (int)scale * maxWidth();
        int gridHeight = (int)scale * maxHeight();
        
        if(cellProfile instanceof GridCell.Triangle)
            gridWidth /= 2;
        
        for(int x = 0; x < maxWidth(); x++) {
            g.setColor(Color.lightGray);
            int x2 = x * (int)scale;
            if(x2 < gridWidth)
                g.drawLine(x2, 0, x2, gridHeight);
            g.drawLine(0, x2, gridWidth, x2);
            for(int y = 0; y < maxHeight(); y++) {
                if(grid[x][y] > 0 && cellProfile instanceof GridCell.Drawable)
                    ((GridCell.Drawable)cellProfile).Draw(g, x, y, this.scale);
            }
        }
    }
    
    /**
     * Set Scale
     * @param scale 
     */
    public void SetScale(double scale) {
        this.scale = scale;
    }
}
