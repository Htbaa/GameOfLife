/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author Christiaan
 */
public class Grid {
    
    long generations = 0;
    public int[][] grid;
    GridCell.Profile cellProfile;
    GridShape.Profile gridProfile;
    
    public Grid(int max_x, int max_y, GridShape.Profile gridProfile, GridCell.Profile cellProfile) {
        this.grid = new int[max_x][max_y];
        this.gridProfile = gridProfile;
        this.cellProfile = cellProfile;
    }
    
    public void Update() {
        generations++;
        int[][] temp = new int[maxWidth()][maxHeight()];
        Point pos = new Point();
        for(int x = 0; x < maxWidth(); x++) {
            for(int y = 0; y < maxHeight(); y++) {
                pos.x = x;
                pos.y = y;
                List<Point> neighbours = gridProfile.GetNeighbours(this, cellProfile, pos);
                int livingNeighbours = 0;
                for(Point neighbour : neighbours) {
                    if(grid[neighbour.x][neighbour.y] > 0)
                        livingNeighbours++;
                }

                if(grid[x][y] == 0 && livingNeighbours == 3)
                    temp[x][y] = 1;
                else if(grid[x][y] > 0 && livingNeighbours < 2 )
                    temp[x][y] = 0;
                else if(grid[x][y] > 0 && (livingNeighbours == 2 || livingNeighbours == 3))
                    temp[x][y] += grid[x][y];
                else if(grid[x][y] > 0 && livingNeighbours > 3)
                    temp[x][y] = 0;
            }
        }
        grid = temp.clone();
    }
    
    public int maxWidth() {
        return this.grid.length;
    }
    
    public int maxHeight() {
        return this.grid[0].length;
    }
}
