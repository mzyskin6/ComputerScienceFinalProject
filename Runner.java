import java.util.Scanner;
import java.util.*;

/**
 * Runner class
 * 
 * @author Michael Zyskind 
 * @version (a version number or a date)
 */
public class Runner
{
    private static GridManager grid = new GridManager(0, 0);
    private static Player player = new Player(0, 0);
    private static NotPlayer opponent = new NotPlayer(0);

    private static boolean hasWon = false;
    private static boolean hasLost = false;
    private static String difficulty = "";
    private static String userInput = "";

    private static List<PosOnGrid> playerPositions = new ArrayList<PosOnGrid>();
    private static List<PosOnGrid> opponentPositions = new ArrayList<PosOnGrid>();

    private static Iterator playerList = playerPositions.iterator();
    private static Iterator opponentList = opponentPositions.iterator();
    
    private static int totalDuplicates = 0;
    private static int listIndex = 0;

    public static void main(String[] args)
    {
        int intInputX = 0;
        int intInputY = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Select Difficulty (By typing the word (Or type the number)): \n1: Easy\n2: Medium\n3: Hard");

        while(!difficulty.equals("Easy") && !difficulty.equals("easy") && 
        !difficulty.equals("Medium") && !difficulty.equals("medium") && 
        !difficulty.equals("Hard") && !difficulty.equals("hard"))
        {
            difficulty = scan.next();

            if(difficulty.equals("1"))
            {
                difficulty = "easy";
            }
            if(difficulty.equals("2"))
            {
                difficulty = "medium";
            }
            if(difficulty.equals("3"))
            {
                difficulty = "hard";
            }
        }

        System.out.println("\nPick diferent sets of numbers to represent\nyour spots on the grid\n");

        if(difficulty.equals("Easy") || difficulty.equals("easy"))
        {
            grid = new GridManager(6, 6);

            while(playerPositions.size() < 2)
            {
                System.out.println("Pick two integers between 0 and 5: ");
                intInputX = scan.nextInt();
                if(intInputX > 5 || intInputX < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 5");
                    intInputX = scan.nextInt();
                }

                intInputY = scan.nextInt();
                if(intInputY > 5 || intInputY < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 5");
                    intInputY = scan.nextInt();
                }

                PosOnGrid newSpace = new PosOnGrid(intInputX, intInputY);

                playerPositions.add(newSpace);
            }

            player = new Player(5, 2);

            while(opponentPositions.size() < 2)
            {
                int xPos = (int)(Math.random() * 6);
                int yPos = (int)(Math.random() * 6);

                while(xPos == intInputX)
                {
                    xPos = (int)(Math.random() * 6);
                }

                while(yPos == intInputY)
                {
                    yPos = (int)(Math.random() * 6);
                }

                PosOnGrid newSpace = new PosOnGrid(xPos, yPos);
                opponentPositions.add(newSpace);
            }

            opponent = new NotPlayer(2);
        }
        else if(difficulty.equals("Medium") || difficulty.equals("medium"))
        {
            grid = new GridManager(10, 10);

            while(playerPositions.size() < 3)
            {

                System.out.println("Pick two integers between 0 and 9: ");
                intInputX = scan.nextInt();
                if(intInputX > 9 || intInputX < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 9");
                    intInputX = scan.nextInt();
                }

                intInputY = scan.nextInt();
                if(intInputY > 9 || intInputY < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 9");
                    intInputY = scan.nextInt();
                }

                PosOnGrid newSpace = new PosOnGrid(intInputX, intInputY);
                playerPositions.add(newSpace);
            }

            player = new Player(8, 3);

            while(opponentPositions.size() < 3)
            {

                int xPos = (int)(Math.random() * 10);
                int yPos = (int)(Math.random() * 10);

                while(xPos == intInputX)
                {
                    xPos = (int)(Math.random() * 10);
                }

                while(yPos == intInputY)
                {
                    yPos = (int)(Math.random() * 10);
                }

                PosOnGrid newSpace = new PosOnGrid(xPos, yPos);
                opponentPositions.add(newSpace);
            }

            opponent = new NotPlayer(3);
        }
        else if(difficulty.equals("Hard") || difficulty.equals("hard"))
        {
            grid = new GridManager(14, 14);

            while(playerPositions.size() < 4)
            {

                System.out.println("Pick two integers between 0 and 13: ");
                intInputX = scan.nextInt();
                if(intInputX > 13 || intInputX < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 13");
                    intInputX = scan.nextInt();
                }

                intInputY = scan.nextInt();
                if(intInputY > 13 || intInputY < 0)
                {
                    System.out.println("Not a valid choice, number must be an integer between 0 and 13");
                    intInputY = scan.nextInt();
                }

                PosOnGrid newSpace = new PosOnGrid(intInputX, intInputY);
                playerPositions.add(newSpace);
            }

            player = new Player(12, 4);

            while(opponentPositions.size() < 4)
            {

                int xPos = (int)(Math.random() * 14);
                int yPos = (int)(Math.random() * 14);

                while(xPos == intInputX)
                {
                    xPos = (int)(Math.random() * 14);
                }

                while(yPos == intInputY)
                {
                    yPos = (int)(Math.random() * 14);
                }

                PosOnGrid newSpace = new PosOnGrid(xPos, yPos);
                opponentPositions.add(newSpace);
            }

            opponent = new NotPlayer(4);
        }else{
            System.out.println("That was not a valid option\n");
            System.out.println("Select Difficulty: \nEasy, Medium, Hard");
            difficulty = scan.next();
        }

        checkUsedSpaces();
        //System.out.print(totalDuplicates + " total duplicates");
        while(totalDuplicates != 0)
        {
            for(int i = 0; i < playerPositions.size() - 1; i++)
            {
                if(playerPositions.get(i).checkGuess(playerPositions.get(i+1).getPosX(), playerPositions.get(i+1).getPosY()))
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();
                    //System.out.println();
                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid newSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(i+1, newSpace);
                    
                    totalDuplicates--;
                    
                    //checkUsedSpaces();
                }
            }
            //System.out.print(totalDuplicates + " total duplicates");
            //checkUsedSpaces();
        }

        System.out.println("\nSpaces Selected: ");
        for(int i = 0; i < playerPositions.size(); i++)
        {
            System.out.print("(" + playerPositions.get(i).getPosX() + "," + playerPositions.get(i).getPosY() + ") ");
        }
        
        //cheats
        //         for(int i = 0; i < opponentPositions.size(); i++)
        //         {
        //             System.out.println();
        //             System.out.println(opponentPositions.get(i).getPosX());
        //             System.out.println(opponentPositions.get(i).getPosY());
        //         }

        System.out.println();
        help();

        menu();
    }

    /**
     * the menu displayed at the beginning of each turn
     * The user will use this to select their action for the next turn
     */
    public static void menu()
    {   
        Scanner scan = new Scanner(System.in);

        inputCheck:
        if(hasLost || player.getNumGuesses() == 0 || 
        opponent.getNumCorrectGuesses() == player.getNumSpacesOnGrid())
        {
            System.out.println("\nGAME OVER");
            //break inputCheck;
            return;
        }
        else
        {
            if(!userInput.equals("Quit") && !userInput.equals("quit"))
            {
                System.out.println("\n");
                grid.drawGrid();

                System.out.println("\nSelect one of the following options: ");
                System.out.println("Guess, Help, or Quit");
                userInput = scan.next();
            }
        }

        mainLoop:
        if(userInput.equals("Guess") || userInput.equals("guess"))
        {
            int guess = guess();

            if(guess == 1)
            {
                if(player.getNumCorrectGuesses() == opponent.getNumSpacesOnGrid())
                {
                    System.out.println("YOU WIN");
                    hasWon = true;
                    System.exit(0);
                    //break mainLoop;
                    //return;
                }
                else
                {
                    menu();
                }
            }
            else if(guess == 0)
            {
                hasLost = true;
                System.exit(0);
                //break mainLoop;
            }
            else
            {
                turn(difficulty);
                menu();
            }
        }
        else if(userInput.equals("Help") || userInput.equals("help"))
        {
            help();
        }
        else if(userInput.equals("Quit") || userInput.equals("quit"))
        {
            break mainLoop;
            //System.exit(0);
            //return; //leave this in, it prevents an overflow error
        }
        else
        {
            System.out.println("\nThat was not a valid choice");
            menu();
        }
    }

    /**
     * checks if the user repeated any spaces
     * will return false if there are duplicate spaces in the playerPositions list
     */
    public static int checkUsedSpaces()
    {
        //int totalDuplicates = 0;
        
        for(int i = 0; i < playerPositions.size() - 1; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+1).getPosX(), playerPositions.get(i+1).getPosY()))
            {
                totalDuplicates++;
                indexInList(i);
            }
        }
        
        for(int i = 0; i < playerPositions.size() - 2; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+2).getPosX(), playerPositions.get(i+2).getPosY()))
            {
                totalDuplicates++;
            }
        }
        
        for(int i = 0; i < playerPositions.size() - 3; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+3).getPosX(), playerPositions.get(i+3).getPosY()))
            {
                totalDuplicates++;
            }
        }
        
        return totalDuplicates;
    }
    
    public static int indexInList(int index)
    {
        listIndex = index;
        return listIndex;
    }

    /**
     * the players guess
     * 
     * return 0 if the player runs out of guesses to make
     * return 1 if the guess was correct
     * return 2 if the guess was wrong but the player hasn't run out of guesses
     */
    public static int guess()
    {
        Scanner scan = new Scanner(System.in);
        int xPos = 0;
        int yPos = 0;

        if(player.getNumGuesses() > 0)
        {
            System.out.println("\nPick an integer between 0 and " + grid.getNumRows());
            xPos = scan.nextInt();

            if(xPos >= grid.getNumRows())
            {
                System.out.println("\nThat was not valid, try again");
                xPos = scan.nextInt();
            }

            System.out.println("Pick an integer between 0 and " + grid.getNumCols());
            yPos = scan.nextInt();

            if(yPos >= grid.getNumCols())
            {
                System.out.println("\nThat was not valid, try again");
                yPos = scan.nextInt();
            }

            grid.setPosOnGrid(xPos, yPos, true);

            if(checkAllSpaces(xPos, yPos, false))
            {
                System.out.println("\nCorrect!");
                player.setNumCorrectGuesses(1);
                //player.changeNumGuesses(1);
                //System.out.println("Remaining guesses: " + player.getNumGuesses());
                return 1;
            }
            else
            {
                System.out.println("\nWrong");
                player.changeNumGuesses(1);
                System.out.println("Remaining guesses: " + player.getNumGuesses());
                return 2;
            }
        }
        else
        {
            System.out.println("You ran out of guesses");
            return 0;
        }
    }

    /**
     * all tutorial information
     */
    public static void help()
    {
        System.out.println("------------------------------------------------------------------");
        System.out.println("HELP:\n");
        System.out.println("The goal is to correctly guess where the opponent is");
        System.out.println("\n" + "The user will have several options each turn");
        System.out.println("Guess: Make a guess, there are a limited number of guesses");
        System.out.println("Help: display this menu");
        System.out.println("Quit: Exit");

        System.out.println("\nX represents where the player has guessed");
        System.out.println("O represents where the opponent has guessed");
        System.out.println("------------------------------------------------------------------");

        menu();
    }

    /**
     * the opponents turn
     * 
     * randomly generates a valid position on the grid
     * and guesses to see if the player is there
     */
    public static void turn(String level)
    {
        int xPos = 0;
        int yPos = 0;

        System.out.println("\nOpponent Turn");
        if(level.equals("Easy") || level.equals("easy"))
        {
            xPos = (int)(Math.random() * 6);
            yPos = (int)(Math.random() * 6);
        }
        else if(level.equals("Medium") || level.equals("medium"))
        {
            xPos = (int)(Math.random() * 10);
            yPos = (int)(Math.random() * 10);
        }
        else if(level.equals("Hard") || level.equals("hard"))
        {
            xPos = (int)(Math.random() * 14);
            yPos = (int)(Math.random() * 14);
        }

        grid.setPosOnGrid(xPos, yPos, false);

        if(checkAllSpaces(xPos, yPos, true))
        {
            System.out.println("The Opponenet Guessed Correctly");

            if(opponent.getNumCorrectGuesses() < opponent.getNumSpacesOnGrid())
            {
                opponent.setNumCorrectGuesses(1);
                System.out.println("Opponent Correct guesses: " + opponent.getNumCorrectGuesses());
            }
            else
            {
                hasLost = true;
            }
        }
        else
        {
            System.out.println("The opponent did not guess correctly");
        }   
    }

    /**
     * inputs of the space to check (posX, posY) and
     * if the player or opponent spaces should be checked (checkPlayer)
     */
    public static boolean checkAllSpaces(int posX, int posY, boolean checkPlayer)
    {
        if(checkPlayer)
        {   
            for(int i = 0; i < playerPositions.size(); i++)
            {
                if(playerPositions.get(i).checkGuess(posX, posY))
                {
                    //playerList.remove();
                    return true;
                }
                //playerList.next();
            }
        }
        else
        {
            for(int i = 0; i < opponentPositions.size(); i++)
            {
                if(opponentPositions.get(i).checkGuess(posX, posY))
                {
                    //opponentList.remove();
                    return true;
                }
                //opponentList.next();
            }
        }
        return false;
    }
}