package gameoflife;

import java.awt.Point;
import java.util.List;

/**
 * A general 2D grid for Game of Life
 * 
 * @author Christiaan
 */
public class Grid {

    /**
     * Counter that keeps track of the number of generations
     */
    public long generations = 0;
    
    /**
     * The actual grid itself
     */
    public int[][] grid;
    
    /**
     * Cell profile that determines the shape of a cell
     */
    protected GridCell.Profile cellProfile;
    
    /**
     * Grid profile that determines what the neighbours of a cell are
     */
    protected GridShape.Profile gridProfile;
   
    /**
     * Constructor
     * @param max_x Max number of columns
     * @param max_y Max number of rows
     * @param gridProfile GridShape.Profile to use
     * @param cellProfile GridCell.Profile to use
     */
    public Grid(int max_x, int max_y, GridShape.Profile gridProfile, GridCell.Profile cellProfile) {
        this.grid = new int[max_x][max_y];
        this.gridProfile = gridProfile;
        this.cellProfile = cellProfile;
    }
    
    /**
     * Update to generate next generation
     */
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

                if(grid[x][y] > 0 && (livingNeighbours < 2 || livingNeighbours > 3))
                    temp[x][y] = 0;
                else if(grid[x][y] > 0 && (livingNeighbours == 2 || livingNeighbours == 3))
                    temp[x][y] = 1 + grid[x][y];
                else if(grid[x][y] == 0 && livingNeighbours == 3)
                    temp[x][y] = 1;
            }
        }
        grid = temp.clone();
    }
    
    /**
     * get maximum width of grid
     * @return int
     */
    public int maxWidth() {
        return this.grid.length;
    }
    
    /**
     * get maximum height of grid
     * @return int
     */    
    public int maxHeight() {
        return this.grid[0].length;
    }
    
    /**
     * Move cells from x1,y1 to x2,y2 to position x3,y3
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3 
     */
    public void CopyCells(int x1, int y1, int x2, int y2, int x3, int y3) {
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                if(x3 + i - x1 < maxWidth() && y3 + j - y1 < maxHeight())
                    this.grid[x3 + i - x1][y3 + j - y1 ] = this.grid[i][j];
    }
    
    /**
     * Change the current cellProfile
     * @param cellProfile 
     */
    public void setCellProfile(GridCell.Profile cellProfile) {
        this.cellProfile = cellProfile;
    }
    
    /**
     * Change the current gridProfile
     * @param gridProfile 
     */
    public void setGridProfile(GridShape.Profile gridProfile) {
        this.gridProfile = gridProfile;
    }
    
    /**
     * Empty grid
     */
    public void Reset() {
        this.grid = new int[maxWidth()][maxHeight()];
    }
    
    /**
     * Populate cells
     * @param xy 
     */
    public void PopulateCells(int[][] xy) {
        for(int[] a : xy) {
            this.grid[a[0]][a[1]] = 1;
        }
    }
}
