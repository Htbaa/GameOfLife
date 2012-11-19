/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Hexagon implements Profile {

    @Override
    public List<Point> GetNeighbours(Point position) {
        List<Point> neighbours = new ArrayList<Point>();
        
        neighbours.add(new Point(-1, 1)); // left
        neighbours.add(new Point(-1, 0));
        
        neighbours.add(new Point(0, -1)); // top
        neighbours.add(new Point(0, 1)); // bottom
        
        neighbours.add(new Point(1, 1)); // right
        neighbours.add(new Point(1, 0));
        
        return neighbours;
    }
    
}
