
/**
 * Write a description of class NotPlayer here.
 * 
 * @author (your name) 
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
