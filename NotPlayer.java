
/**
 * Defines the opponent
 * 
 * @author Michael Zyskind 
 * @version (a version number or a date)
 */
public class NotPlayer
{
    private int xPos;
    private int yPos;
    
    public NotPlayer(int posX, int posY)
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
    
    /**takes two integers as input to check and see if those match the opponents position
     * the input is the users guess
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
