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
public class Triangle implements Profile {

    @Override
    public List<Point> GetNeighbours(Point position) {
        List<Point> neighbours = new ArrayList<Point>();

        if(position.x % 2 == 0) {
            neighbours.add(new Point(-1, -1));
            neighbours.add(new Point(0, -1));
            neighbours.add(new Point(1, -1));
            neighbours.add(new Point(2, -1));
            neighbours.add(new Point(3, -1));
            
            neighbours.add(new Point(-2, 0));
            neighbours.add(new Point(-1, 0));
            neighbours.add(new Point(1, 0));
            neighbours.add(new Point(2, 0));
            
            neighbours.add(new Point(-2, 1));
            neighbours.add(new Point(-1, -1));
            neighbours.add(new Point(0, 1));
        }
        else {
            neighbours.add(new Point(0, -1));
            neighbours.add(new Point(1, -1));
            neighbours.add(new Point(2, -1));
            
            neighbours.add(new Point(-2, 0));
            neighbours.add(new Point(-1, 0));
            neighbours.add(new Point(1, 0));
            neighbours.add(new Point(2, 0));
            
            neighbours.add(new Point(-3, 1));
            neighbours.add(new Point(-2, 1));
            neighbours.add(new Point(-1, 1));
            neighbours.add(new Point(0, 1));
            neighbours.add(new Point(1, 1));
        }

        return neighbours;
    }
}
