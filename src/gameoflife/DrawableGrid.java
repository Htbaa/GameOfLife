/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import GridShape.Profile;
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
        for(int x = 0; x < maxWidth(); x++) {
            for(int y = 0; y < maxHeight(); y++) {
                if(grid[x][y] > 0)
                    cellProfile.Draw(g, x, y, this.scale);
            }
        }
    }
    
    public void SetScale(double scale) {
        this.scale = scale;
    }
}
