
/**
 * Defines the player
 * 
 * @author Michael Zyskind
 * @version (a version number or a date)
 */
public class Player
{
    private int xPos;
    private int yPos;
    private int numGuesses;

    /**
     * Constructor
     * inputs posX and posY store the position on the grid
     * input guesses stores the number of guesses the player can make before losing
     */
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

    /**
     * takes two inputs (a guess) to see if the guess was correct
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

    public int getNumGuesses()
    {
        return numGuesses;
    }

    /**
     * change the remaining amount of guesses by amount
     */
    public int changeNumGuesses(int amount)
    {
        numGuesses -= amount;
        return numGuesses;
    }
}
