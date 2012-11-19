/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Square implements Profile, Drawable {

    @Override
    public void Draw(Graphics g, int x, int y, double size) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.fillRect(x * (int)size, y * (int)size, (int)size, (int)size);
        g2.setColor(Color.red);
        g2.drawRect(x * (int)size, y * (int)size, (int)size, (int)size);
        
    }

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