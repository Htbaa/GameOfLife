/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import gameoflife.Grid;
import gameoflife.GridCoord;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public interface Profile {
    
    double size = 10.0;
    
    public void Draw(Graphics g, int x, int y);
    
    public List<GridCoord> GetNeighbours();
    
}