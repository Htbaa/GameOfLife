package GridCell;

import java.awt.Graphics;

/**
 * Interface for making a GridCell drawable
 * @author Christiaan
 */
public interface Drawable {
    
    /**
     * Draw cell
     * @param g Graphics object
     * @param x x-position
     * @param y y-position
     * @param size size of shape
     * @param age age of cell
     */
    public void Draw(Graphics g, int x, int y, double size, int age);
}
