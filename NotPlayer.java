
/**
 * Defines the opponent
 * 
 * @author Michael Zyskind 
 * @version May 21, 2016
 */
public class NotPlayer extends PlayerType
{
    private int spacesOnGrid; //total number of spaces on the grid
    private int spacesCorrectlyGuessed; //total number of player spaces correctly guessed
    
    /**
     * Constructor
     * two inputs used to store position on grid
     */
    public NotPlayer(int numSpacesOnGrid)
    {
        spacesOnGrid = numSpacesOnGrid;
    }
    
    public int getNumSpacesOnGrid()
    {
        return spacesOnGrid;
    }
    
    public int getNumCorrectGuesses()
    {
        return spacesCorrectlyGuessed;
    }
    
    /**
     * sets the number of correct guesses
     * uses the integer input amount as the amount to change
     */
    public int setNumCorrectGuesses(int amount)
    {
        spacesCorrectlyGuessed += amount;
        return spacesCorrectlyGuessed;
    }
}
