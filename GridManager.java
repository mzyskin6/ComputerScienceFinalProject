
/**
 * creates and updates the grid
 * 
 * @author Michael Zyskind 
 * @version May 16, 2016
 */
public class GridManager
{
    private String[][] grid;

    private int rows;
    private int cols;

    /**
     * constructor
     * creates a grid with the given inputs and gives it
     * default starting values
     */
    public GridManager(int numRows, int numCols)
    {
        grid = new String[numRows][numCols];

        for(int x = 0; x < grid.length; x++)
        {
            for(int y = 0; y < grid[0].length; y++)
            {
                grid[x][y] = "-";
            }
        }

        rows = numRows;
        cols = numCols;
    }

    
    /**
     * gets the number of rows in the grid
     */
    public int getNumRows()
    {
        return rows;
    }

    
    /**
     * gets the number of columns in the grid
     */
    public int getNumCols()
    {
        return cols;
    }

    
    /**
     * draws the grid
     */
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

    
    /**
     * sets a specified position on the grid to either X or O depending
     * on whether or not it is to represent a player guess or the
     * opponents guess
     */
    public String[][] setPosOnGrid(int posX, int posY, boolean isPlayer)
    {
        if(isPlayer)
        {
            grid[posX][posY] = "X";
        }
        else
        {
            grid[posX][posY] = "O";
        }
        
        return grid;
    }
}
