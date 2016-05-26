
/**
 * will store an X and Y position that is a valid space on the grid
 * for both the player and the opponent
 * 
 * @author Michael Zyskind
 * @version May 25, 2016
 */
public class PosOnGrid
{
    private int xPos;
    private int yPos;
    
    /**
     * constructor
     * takes two integer inputs stores a space
     */
    public PosOnGrid(int posX, int posY)
    {
        xPos = posX;
        yPos = posY;
    }
    
    public int getPosX()
    {
        return xPos;
    }
    
    public int getPosY()
    {
        return yPos;
    }
    
    /**
     * checks the input with the stored values to see if they match
     * to be used with guessing to see if the guess is correct
     */
    public boolean checkGuess(int posX, int posY)
    {
        if(posX == xPos && posY == yPos)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
