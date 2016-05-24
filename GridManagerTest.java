

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GridManagerTest.
 *
 * @author  Michael Zyskind
 * @version May 21, 2016
 */
public class GridManagerTest
{
    /**
     * Default constructor for test class GridManagerTest
     */
    public GridManagerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * tests the setPosOnGrid method
     * tests if the player guessed
     */
    @Test
    public void testSetPosOnGridPlayer()
    {
        GridManager newGrid = new GridManager(5, 5);
        String[][] answersGrid = new String[5][5];
        
        for(int x = 0; x < answersGrid.length; x++)
        {
            for(int y = 0; y < answersGrid[0].length; y++)
            {
                answersGrid[x][y] = "-";
            }
        }
        
        answersGrid[2][3] = "X";
        
        assertEquals(answersGrid, newGrid.setPosOnGrid(2, 3, true));
    }
    
    /**
     * tests the setPosOnGrid method
     * tests if the opponent guessed
     */
    @Test
    public void testSetPosOnGridOpponent()
    {
        GridManager newGrid = new GridManager(5, 5);
        String[][] answersGrid = new String[5][5];
        
        for(int x = 0; x < answersGrid.length; x++)
        {
            for(int y = 0; y < answersGrid[0].length; y++)
            {
                answersGrid[x][y] = "-";
            }
        }
        
        answersGrid[2][3] = "O";
        
        assertEquals(answersGrid, newGrid.setPosOnGrid(2, 3, false));
    }
}
