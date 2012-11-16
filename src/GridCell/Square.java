/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GridCell;

import gameoflife.Grid;
import gameoflife.GridCoord;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Square implements Profile {

    @Override
    public void Draw(Graphics g, int x, int y, double size) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.drawRect(x * (int)size, y * (int)size, (int)size, (int)size);
    }

    @Override
    public List<GridCoord> GetNeighbours() {
        List<GridCoord> neighbours = new ArrayList<GridCoord>();

        neighbours.add(new GridCoord(-1, 0)); // left
        neighbours.add(new GridCoord(1, 0)); // right
        neighbours.add(new GridCoord(0, -1)); // top
        neighbours.add(new GridCoord(0, 1)); // bottom
        
        neighbours.add(new GridCoord(-1, -1)); // topleft
        neighbours.add(new GridCoord(1, -1)); // topright
        neighbours.add(new GridCoord(-1, 1)); // bottomleft
        neighbours.add(new GridCoord(1, 1)); // bottomright
        
        return neighbours;
    }
}