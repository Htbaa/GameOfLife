/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import GridShape.Profile;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Christiaan
 */
public class DrawableGrid extends Grid {

    double scale = 10.0;
    
    public DrawableGrid(int max_x, int max_y, Profile gridProfile, GridCell.Profile cellProfile) {
        super(max_x, max_y, gridProfile, cellProfile);
    }

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
    
    public void SetScale(double scale) {
        this.scale = scale;
    }
}
