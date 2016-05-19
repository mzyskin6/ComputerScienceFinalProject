
/**
 * will store an X and Y position that is a valid space on the grid
 * for both the player and the opponent
 * 
 * @author Michael Zyskind
 * @version (a version number or a date)
 */
public class PosOnGrid
{
    private int xPos;
    private int yPos;
    
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
