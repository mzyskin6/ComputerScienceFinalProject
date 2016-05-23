

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  Michael Zyskind
 * @version (a version number or a date)
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
     * tests the setNumCorrectGuesses method with a positive input
     */
    @Test
    public void testSetNumCorrectGuessesPositive()
    {
        Player newPlayer = new Player(5, 2);
        
        assertEquals(2, newPlayer.setNumCorrectGuesses(2));
    }
    
    /**
     * tests the setNumCorrectGuesses method with a negative input
     */
    @Test
    public void testSetNumCorrectGuessesNegative()
    {
        Player newPlayer = new Player(5, 2);
        
        assertEquals(-2, newPlayer.setNumCorrectGuesses(-2));
    }
    
    /**
     * tests the setNumCorrectGuesses method with multiple changes
     */
    @Test
    public void testSetNumCorrectGuessesMultiple()
    {
        Player newPlayer = new Player(5, 2);
        
        newPlayer.setNumCorrectGuesses(4);
        newPlayer.setNumCorrectGuesses(2);
        newPlayer.setNumCorrectGuesses(-1);
        
        assertEquals(5, newPlayer.setNumCorrectGuesses(0));
    }
}
