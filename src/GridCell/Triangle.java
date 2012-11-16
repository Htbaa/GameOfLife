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
public class Triangle implements Profile {
    
    @Override
    public void Draw(Graphics g, int x, int y, double size) {
        Graphics2D g2 = (Graphics2D)g;
        boolean isOdd = x % 2 == 0;
        
        x = x/2;

        int base_x = x * (int)size, base_y = y * (int)size;
        g2.setColor(Color.red);
        if(isOdd) {    
            g2.drawLine(base_x, base_y, base_x + (int)size, base_y);
            g2.drawLine(base_x, base_y, base_x, base_y + (int)size);
            g2.drawLine(base_x, base_y + (int)size, base_x + (int)size, base_y);
        }
        else {
            g2.drawLine(base_x, base_y + (int)size, base_x + (int)size, base_y + (int)size);
            g2.drawLine(base_x + (int)size, base_y, base_x, base_y + (int)size);
            g2.drawLine(base_x + (int)size, base_y, base_x + (int)size, base_y + (int)size);
        }
    }

    @Override
    public List<Point> GetNeighbours() {
        List<Point> neighbours = new ArrayList<Point>();

        neighbours.add(new Point(1, 0));
        neighbours.add(new Point(-1, 0));
        neighbours.add(new Point(-1, -1));
        neighbours.add(new Point(1, -1));

        neighbours.add(new Point(0, -1));
        neighbours.add(new Point(2, -1));
        neighbours.add(new Point(3, -1));
        neighbours.add(new Point(-2, 0));
        neighbours.add(new Point(2, 0));
        neighbours.add(new Point(-2, 1));
        neighbours.add(new Point(-1, -1));
        neighbours.add(new Point(0, 1));

        return neighbours;
    }
}
