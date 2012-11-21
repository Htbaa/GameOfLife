/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Square - a 4 sided shape
 * @author Christiaan
 */
public class Square implements Profile {

    @Override
    public List<Point> GetNeighbours(Point position) {
        List<Point> neighbours = new ArrayList<Point>();

        neighbours.add(new Point(-1, 0)); // left
        neighbours.add(new Point(1, 0)); // right
        neighbours.add(new Point(0, -1)); // top
        neighbours.add(new Point(0, 1)); // bottom
        
        neighbours.add(new Point(-1, -1)); // topleft
        neighbours.add(new Point(1, -1)); // topright
        neighbours.add(new Point(-1, 1)); // bottomleft
        neighbours.add(new Point(1, 1)); // bottomright
        return neighbours;
    }
}