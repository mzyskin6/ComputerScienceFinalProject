
/**
 * Defines the opponent
 * 
 * @author Michael Zyskind 
 * @version (a version number or a date)
 */
public class NotPlayer
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
    
    public int setNumCorrectGuesses(int amount)
    {
        spacesCorrectlyGuessed += amount;
        return spacesCorrectlyGuessed;
    }
}
