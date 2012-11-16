/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridShape;

import gameoflife.Grid;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public interface Profile {
    
    public List<Point> GetNeighbours(Grid grid, GridCell.Profile cellProfile, Point position);
    
}
