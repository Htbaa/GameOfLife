package GridShape;

import gameoflife.Grid;
import java.awt.Point;
import java.util.List;

/**
 * GridShape profile
 * @author Christiaan
 */
public interface Profile {
    
    /**
     * Retrieve cell neighbours
     * @param grid
     * @param cellProfile
     * @param position Position of cell
     * @return List<Point>
     */
    public List<Point> GetNeighbours(Grid grid, GridCell.Profile cellProfile, Point position);
}
