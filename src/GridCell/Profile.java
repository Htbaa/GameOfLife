package GridCell;

import java.awt.Point;
import java.util.List;

/**
 * A GridCell profile
 * @author Christiaan
 */
public interface Profile {

    /**
     * Retrieve neighbour positions based on position of cell
     * @param position
     * @return List<Point> a collection of neighbouring positions offset to position
     */
    public List<Point> GetNeighbours(Point position);
}