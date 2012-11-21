package GridShape;

import gameoflife.Grid;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A basic square grid - cells can't move across the grid's border
 * @author Christiaan
 */
public class Basic implements Profile {

    @Override
    public List<Point> GetNeighbours(Grid grid, GridCell.Profile cellProfile, Point position) {
        List<Point> potentialNeighbours = cellProfile.GetNeighbours(position);
        List<Point> neighbours = new ArrayList<Point>();
        
        for(Point p : potentialNeighbours) {
            int x = position.x + p.x;
            int y = position.y + p.y;
            if(x >= 0 && x < grid.maxWidth() && y >= 0 && y < grid.maxHeight()) {
                neighbours.add(new Point(x,y));
            }
        }

        return neighbours;
    }
}
