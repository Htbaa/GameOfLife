/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author Christiaan
 */
public class DrawableHexagon extends Hexagon implements Drawable {

    @Override
    public void Draw(Graphics g, int x, int y, double size) {
        int oldX = x, oldY = y;
        Graphics2D g2 = (Graphics2D)g;
        int half = (int)(size / 2);
        int quarter = (int)(size / 4);
        boolean isOdd = x % 2 == 0;

        x = x * (int)(size - quarter);
        if(isOdd) {
            y = y * (int)(size);
        }
        else {
            y = y * (int)(size) + (int)(size - half);
        }

        int[] xs = { x + quarter, x + (int)size - quarter, x + (int)size, x + (int)size - quarter, x + quarter, x};
        int[] ys = { y, y, y + half, y + (int)size, y + (int)size, y + half};
        Polygon hexagon = new Polygon(xs, ys, xs.length);
        g2.setColor(Color.black);
        g2.fillPolygon(hexagon);
        g2.setColor(Color.red);
        g2.drawPolygon(hexagon);
        //g2.setColor(Color.WHITE);
        //g2.drawString(oldX+","+oldY, x + quarter, y + half);
    }
}
