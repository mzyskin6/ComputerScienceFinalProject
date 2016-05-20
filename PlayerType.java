
/**
 * Abstract Class
 * defines some methods in both the Player and NotPlayer classes
 * 
 * @author Michael Zyskind
 * @version (version number or date here)
 */
public abstract class PlayerType
{
    /**
     * gets the number of spaces on the grid
     */
    abstract int getNumSpacesOnGrid();
    
    /**
     * gets the number of correct guesses
     */
    abstract int getNumCorrectGuesses();
    
    /**
     * sets the number of correct guesses
     * using the input num as the amount to change it by
     */
    abstract int setNumCorrectGuesses(int num);
}
