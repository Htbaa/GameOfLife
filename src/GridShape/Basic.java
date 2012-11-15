/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridShape;

import gameoflife.Grid;
import gameoflife.GridCoord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Basic implements Profile {

    @Override
    public List<GridCoord> GetNeighbours(Grid grid, GridCell.Profile cellProfile, GridCoord position) {
        List<GridCoord> potentialNeighbours = cellProfile.GetNeighbours();
        List<GridCoord> neighbours = new ArrayList<GridCoord>();
        
        for(GridCoord p : potentialNeighbours) {
            int x = position.x + p.x;
            int y = position.y + p.y;
            if(x >= 0 && x < grid.maxWidth() && y >= 0 && y < grid.maxHeight()) {
                neighbours.add(new GridCoord(x,y));
            }
        }

        return neighbours;
    }
}
