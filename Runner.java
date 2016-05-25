import java.util.Scanner;
import java.util.*;

/**
 * Runner class
 * 
 * @author Michael Zyskind 
 * @version May 24, 2016
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

    private static List<PosOnGrid> guessedSpaces = new ArrayList<PosOnGrid>();

    private static Iterator playerList = playerPositions.iterator();
    private static Iterator opponentList = opponentPositions.iterator();

    private static int numSpaces = 0;

    public static void main(String[] args)
    {
        int intInputX = 0;
        int intInputY = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Guess!");
        System.out.println("Created By: Michael Zyskind");
        System.out.println("-----------------------------------------");
        System.out.println();

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
            
            try
            {
                int difficultyInteger = Integer.parseInt(difficulty);
                
                if(difficultyInteger < 1 || difficultyInteger > 3)
                {
                    System.out.println("That was not a valid input, try again");
                    //difficulty = scan.next();
                }
            }
            catch(Exception exception)
            {
                System.out.println("That was not a valid input, try again");
                //difficulty = scan.next();
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
                numSpaces++;

                if(!checkUsedSpaces())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }
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
                numSpaces++;

                if(!checkUsedSpaces())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }

                if(!checkUsedSpacesMedium())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }
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
                numSpaces++;

                if(!checkUsedSpaces())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }

                if(!checkUsedSpacesMedium())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }

                if(!checkUsedSpacesHard())
                {
                    System.out.println("\nYou already used that space, \nPlease use a different space");
                    System.out.print("New X Position: ");
                    intInputX = scan.nextInt();

                    System.out.print("New Y Position: ");
                    intInputY = scan.nextInt();

                    PosOnGrid replaceSpace = new PosOnGrid(intInputX, intInputY);
                    playerPositions.set(numSpaces-1, replaceSpace);
                }
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

        /*#
         * this displays the users final location
         */
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
    }

    /**
     * the menu displayed at the beginning of each turn
     * The user will use this to select their action for the next turn
     */
    public static void menu()
    {   
        Scanner scan = new Scanner(System.in);

        if(hasLost || player.getNumGuesses() == 0 || 
        opponent.getNumCorrectGuesses() == player.getNumSpacesOnGrid())
        {
            System.out.println("\nGAME OVER");

            return;
        }
        else
        {
            if(!userInput.equals("Quit") && !userInput.equals("quit"))
            {
                System.out.println("\n");
                grid.drawGrid();

                System.out.println("\nSelect one of the following options(Type the number): ");

                System.out.println("1: Guess");
                System.out.println("2: Help");
                System.out.println("3: Show Score");
                System.out.println("4: Quit");

                userInput = scan.next();
            }
        }

        if(userInput.equals("1")) //user selection of guess
        {
            int guess = guess();

            if(guess == 1)
            {
                if(player.getNumCorrectGuesses() == opponent.getNumSpacesOnGrid())
                {
                    System.out.println("YOU WIN");
                    hasWon = true;
                    //System.exit(0);
                    return;
                }
                else
                {
                    menu();
                }
            }
            else if(guess == 0)
            {
                hasLost = true;
                //System.exit(0);
                return;
            }
            else
            {
                turn(difficulty);
                menu();
            }
        }
        else if(userInput.equals("2")) //user selection of help
        {
            help();
        }
        else if(userInput.equals("3")) //user selection of show score
        {
            displayPlayerAndOpponentPos();
        }
        else if(userInput.equals("4")) //user selection of quit
        {
            return;
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
     * 
     * CHECKS THE Xth WITH THE Xth+1
     */
    public static boolean checkUsedSpaces()
    {
        for(int i = 0; i < playerPositions.size() - 1; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+1).getPosX(), playerPositions.get(i+1).getPosY()))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * checks if the user repeated any spaces
     * will return false if there are duplicate spaces in the playerPositions list
     * 
     * CHECKS THE Xth WITH THE Xth+2
     */
    public static boolean checkUsedSpacesMedium()
    {
        for(int i = 0; i < playerPositions.size() - 2; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+2).getPosX(), playerPositions.get(i+2).getPosY()))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * checks if the user repeated any spaces
     * will return false if there are duplicate spaces in the playerPositions list
     * 
     * CHECKS THE Xth WITH THE Xth+3
     */
    public static boolean checkUsedSpacesHard()
    {
        for(int i = 0; i < playerPositions.size() - 3; i++)
        {
            if(playerPositions.get(i).checkGuess(playerPositions.get(i+3).getPosX(), playerPositions.get(i+3).getPosY()))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * displays the spaces the user has selected
     * and the number of correct guesses for both the player and the opponent
     */
    public static void displayPlayerAndOpponentPos()
    {
        System.out.println();
        System.out.println("--------------------------------------------");

        System.out.println("Player spaces:");
        for(int i = 0; i < playerPositions.size(); i++)
        {
            System.out.println("(" + playerPositions.get(i).getPosX() + "," + playerPositions.get(i).getPosY() + ")");
        }

        System.out.println();

        System.out.println("Number of spaces the player guessed correctly: " + player.getNumCorrectGuesses());
        System.out.println();
        System.out.println("Number of spaces the opponent guessed correctly: " + opponent.getNumCorrectGuesses());

        System.out.println();
        System.out.println("--------------------------------------------");

        menu();
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
            System.out.println("\nPick an integer between 0 and " + (grid.getNumRows()-1));
            xPos = scan.nextInt();

            if(xPos >= grid.getNumRows())
            {
                System.out.println("\nThat was not valid, try again");
                xPos = scan.nextInt();
            }

            System.out.println("Pick an integer between 0 and " + (grid.getNumCols()-1));
            yPos = scan.nextInt();

            if(yPos >= grid.getNumCols())
            {
                System.out.println("\nThat was not valid, try again");
                yPos = scan.nextInt();
            }

//             PosOnGrid newSpace = new PosOnGrid(xPos, yPos);
//             guessedSpaces.add(newSpace);
// 
//             if(guessedSpaces.size() > 1)
//             {
//                 for(int x = 0; x < guessedSpaces.size(); x++)
//                 {
//                     for(int i = guessedSpaces.size() - 1; i > 0; i--)
//                     {
//                         if(guessedSpaces.get(i).checkGuess(guessedSpaces.get(x).getPosX(), guessedSpaces.get(x).getPosY()))
//                         {
//                             System.out.println("You already guessed that, \nTry again");
// 
//                             System.out.println();
// 
//                             System.out.println("\nPick an integer between 0 and " + grid.getNumRows());
//                             xPos = scan.nextInt();
// 
//                             if(xPos >= grid.getNumRows())
//                             {
//                                 System.out.println("\nThat was not valid, try again");
//                                 xPos = scan.nextInt();
//                             }
// 
//                             System.out.println("Pick an integer between 0 and " + grid.getNumCols());
//                             yPos = scan.nextInt();
// 
//                             if(yPos >= grid.getNumCols())
//                             {
//                                 System.out.println("\nThat was not valid, try again");
//                                 yPos = scan.nextInt();
//                             }
//                             
//                             PosOnGrid replaceSpace = new PosOnGrid(xPos, yPos);
//                             guessedSpaces.set(x, replaceSpace);
//                         }
//                     }
//                 }
//             }

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
        System.out.println("Show Score: Displays the spaces the player selected and the\n   number of correct guesses both the player and the opponent made");
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