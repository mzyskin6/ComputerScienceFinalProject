

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NotPlayerTest.
 *
 * @author  Michael Zyskind
 * @version May 23, 2016
 */
public class NotPlayerTest
{
    /**
     * Default constructor for test class NotPlayerTest
     */
    public NotPlayerTest()
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
        NotPlayer newPlayer = new NotPlayer(2);
        
        assertEquals(2, newPlayer.setNumCorrectGuesses(2));
    }
    
    /**
     * tests the setNumCorrectGuesses method with a negative input
     */
    @Test
    public void testSetNumCorrectGuessesNegative()
    {
        NotPlayer newPlayer = new NotPlayer(2);
        
        assertEquals(-2, newPlayer.setNumCorrectGuesses(-2));
    }
    
    /**
     * tests the setNumCorrectGuesses method with multiple changes
     */
    @Test
    public void testSetNumCorrectGuessesMultiple()
    {
        NotPlayer newPlayer = new NotPlayer(2);
        
        newPlayer.setNumCorrectGuesses(4);
        newPlayer.setNumCorrectGuesses(2);
        newPlayer.setNumCorrectGuesses(-1);
        
        assertEquals(5, newPlayer.setNumCorrectGuesses(0));
    }
}
