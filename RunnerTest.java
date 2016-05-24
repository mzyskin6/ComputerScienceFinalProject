

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RunnerTest.
 *
 * @author  Michael Zyskind
 * @version May 23, 2016
 */
public class RunnerTest
{
    /**
     * Default constructor for test class RunnerTest
     */
    public RunnerTest()
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
     * tests the checkAllSpaces method in the runner class
     * THIS TEST IS NOT YET FINISHED AND DOES NOT WORK
     */
    //@Test
    public void testCheckSpaces()
    {
        Runner newRunner = new Runner();
        
        PosOnGrid newPos = new PosOnGrid(4, 2);
        
        assertEquals("Test does not work properly", true, newRunner.checkAllSpaces(4, 2, true));
    }
}
