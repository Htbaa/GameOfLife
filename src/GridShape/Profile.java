/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridShape;

import gameoflife.Grid;
import gameoflife.GridCoord;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public interface Profile {
    
    public List<GridCoord> GetNeighbours(Grid grid, GridCell.Profile cellProfile, GridCoord position);
    
}
