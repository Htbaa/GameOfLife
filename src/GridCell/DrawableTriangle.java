/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Christiaan
 */
public class DrawableTriangle extends Triangle implements Drawable {
    
    @Override
    public void Draw(Graphics g, int x, int y, double size) {
        Graphics2D g2 = (Graphics2D)g;
        boolean isOdd = x % 2 == 0;
        
        x = x/2;
        int base_x = x * (int)size, base_y = y * (int)size;
        
        Point p1,p2,p3;
        g2.setColor(Color.red);
        if(isOdd) {    
            p1 = new Point(base_x, base_y);
            p2 = new Point(base_x + (int)size, base_y);
            p3 = new Point(base_x, base_y + (int)size);
        }
        else {
            p1 = new Point(base_x, base_y + (int)size);
            p2 = new Point(base_x + (int)size, base_y);
            p3 = new Point(base_x + (int)size, base_y + (int)size);
        }

        int[] xs = { p1.x, p2.x, p3.x };
        int[] ys = { p1.y, p2.y, p3.y };
        Polygon triangle = new Polygon(xs, ys, xs.length);
        g2.setColor(Color.black);
        g2.fillPolygon(triangle);
        g2.setColor(Color.red);
        g2.drawPolygon(triangle);
    }
}
