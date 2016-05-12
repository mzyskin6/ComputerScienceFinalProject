
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private int xPos;
    private int yPos;
    private int numGuesses;
    
    public Player(int posX, int posY, int guesses)
    {
        xPos = posX;
        yPos = posY;
        numGuesses = guesses;
    }
    
    public int getPosX()
    {
        return xPos;
    }
    
    public int getPosY()
    {
        return yPos;
    }
    
    public int getNumGuesses()
    {
        return numGuesses;
    }
    
    public int changeNumGuesses(int amount)
    {
        numGuesses -= amount;
        return numGuesses;
    }
}
