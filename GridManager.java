
/**
 * Write a description of class GridManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridManager
{
    private String[][] grid;
    
    private int rows;
    private int cols;
    
    public GridManager(int numRows, int numCols)
    {
        grid = new String[numRows][numCols];
        
        for(int x = 0; x < grid.length; x++)
        {
            for(int y = 0; y < grid[0].length; y++)
            {
                grid[x][y] = "O";
            }
        }
        
        rows = numRows;
        cols = numCols;
    }
    
    public int getNumRows()
    {
        return rows;
    }
    
    public int getNumCols()
    {
        return cols;
    }
    
    public void drawGrid()
    {
        for(int x = 0; x < grid.length; x++)
        {
            for(int y = 0; y < grid[0].length; y++)
            {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }
    
    public String[][] setPosOnGrid(int posX, int posY)
    {
        grid[posX][posY] = "X";
        return grid;
    }
}
