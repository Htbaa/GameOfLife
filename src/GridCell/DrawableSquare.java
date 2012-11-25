package GridCell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Drawable implementation of a Square
 * @author Christiaan
 */
public class DrawableSquare extends Square implements Drawable {

    @Override
    public void Draw(Graphics g, int x, int y, double size, int age) {
        Graphics2D g2 = (Graphics2D)g;
        int rgb = 255 - age;
        if(rgb < 0)
            rgb = 0;
        Color c = new Color(rgb, rgb, 0);
        g2.setColor(c);
        g2.fillRect(x * (int)size, y * (int)size, (int)size, (int)size);
        g2.setColor(Color.red);
        g2.drawRect(x * (int)size, y * (int)size, (int)size, (int)size);
        
    }
}
