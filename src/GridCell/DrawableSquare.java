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
    public void Draw(Graphics g, int x, int y, double size) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.fillRect(x * (int)size, y * (int)size, (int)size, (int)size);
        g2.setColor(Color.red);
        g2.drawRect(x * (int)size, y * (int)size, (int)size, (int)size);
        
    }
}
