
/**
 * Defines the player
 * 
 * @author Michael Zyskind
 * @version (a version number or a date)
 */
public class Player extends PlayerType
{
    private int numGuesses; //total number of guesses that can be made
    private int spacesOnGrid; //number of X and Y positions on the grid
    private int spacesCorrectlyGuessed; //number of (X, Y) positions(of the opponent)correctly guessed

    /**
     * Constructor
     * inputs posX and posY store the position on the grid
     * input guesses stores the number of guesses the player can make before losing
     */
    public Player(int guesses, int numSpacesOnGrid)
    {
        numGuesses = guesses;
        spacesOnGrid = numSpacesOnGrid;
    }

    /**
     * gets the remaining number of guesses
     */
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
    
    public int getNumSpacesOnGrid()
    {
        return spacesOnGrid;
    }
    
    public int getNumCorrectGuesses()
    {
        return spacesCorrectlyGuessed;
    }
    
    public int setNumCorrectGuesses(int amount)
    {
        spacesCorrectlyGuessed += amount;
        return spacesCorrectlyGuessed;
    }
}
