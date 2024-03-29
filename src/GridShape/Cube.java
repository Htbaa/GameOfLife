package GridShape;

import gameoflife.Grid;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A cubical representation of the grid - cells can move across borders to
 * end up on the other side of the grid
 * @author Christiaan
 */
public class Cube implements Profile {
    
    @Override
    public List<Point> GetNeighbours(Grid grid, GridCell.Profile cellProfile, Point position) {
        List<Point> potentialNeighbours = cellProfile.GetNeighbours(position);
        List<Point> neighbours = new ArrayList<Point>();
        
        for(Point p : potentialNeighbours) {
            int x = position.x + p.x;
            int y = position.y + p.y;
            
            if(x < 0)
                x += grid.maxWidth();
            else if(x >= grid.maxWidth())
                x -= grid.maxWidth();
            

            if(y < 0)
                y += grid.maxHeight();
            else if(y >= grid.maxHeight())
                y -= grid.maxHeight();
            
            neighbours.add(new Point(x,y));
        }

        return neighbours;
    }
}
