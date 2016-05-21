import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PosOnGridTest.
 *
 * @author  Michael Zyskind
 * @version (a version number or a date)
 */
public class PosOnGridTest
{    
    /**
     * Default constructor for test class PosOnGridTest
     */
    public PosOnGridTest()
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
     * tests the checkGuess method
     * expected to return true
     */
    @Test
    public void testCheckGuessTrue()
    {
        PosOnGrid newSpace = new PosOnGrid(1, 2);
        
        assertEquals(true, newSpace.checkGuess(1, 2));
    }
    
    /**
     * tests the checkGuess method
     * expected to return false
     */
    @Test
    public void testCheckGuessFalse()
    {
        PosOnGrid newSpace = new PosOnGrid(1, 2);
        
        assertEquals("This test should fail", true, newSpace.checkGuess(2, 1));
    }
}
