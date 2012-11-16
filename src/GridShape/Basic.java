/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridShape;

import gameoflife.Grid;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Basic implements Profile {

    @Override
    public List<Point> GetNeighbours(Grid grid, GridCell.Profile cellProfile, Point position) {
        List<Point> potentialNeighbours = cellProfile.GetNeighbours();
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
