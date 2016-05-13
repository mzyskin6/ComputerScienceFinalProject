import java.util.Scanner;

/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    private static GridManager grid = new GridManager(0, 0);
    private static Player player = new Player(0, 0, 0);
    private static NotPlayer opponent = new NotPlayer(0, 0);

    private static boolean hasWon = false;
    private static boolean hasLost = false;
    private static String difficulty = "";

    public static void main(String[] args)
    {
        String userInput = "";
        int intInputX = 0;
        int intInputY = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Select Difficulty: \nEasy, Medium, Hard");
        difficulty = scan.next();

        if(difficulty.equals("Easy") || difficulty.equals("easy"))
        {
            grid = new GridManager(6, 6);

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

            player = new Player(intInputX, intInputY, 5);

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

            opponent = new NotPlayer(xPos, yPos);
        }
        else if(difficulty.equals("Medium") || difficulty.equals("medium"))
        {
            grid = new GridManager(10, 10);

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

            player = new Player(intInputX, intInputY, 8);

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

            opponent = new NotPlayer(xPos, yPos);
        }
        else if(difficulty.equals("Hard") || difficulty.equals("hard"))
        {
            grid = new GridManager(14, 14);

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

            player = new Player(intInputX, intInputY, 12);

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

            opponent = new NotPlayer(xPos, yPos);
        }else{
            System.out.println("That was not a valid option\n");
            System.out.println("Select Difficulty: \nEasy, Medium, Hard");
            difficulty = scan.next();
        }

        System.out.println();
        grid.drawGrid();

        //cheats
        //System.out.println("\n" + opponent.getPosX() + "\n" + opponent.getPosY());

        //boolean playerTurn = true;

        //if(playerTurn)
        //{
        System.out.println("\nSelect one of the following options: ");
        System.out.println("Guess, Help, End Turn, or Quit");
        userInput = scan.next();

        if(userInput.equals("Guess") || userInput.equals("guess"))
        {
            int guess = guess();

            if(guess == 1)
            {
                hasWon = true;
            }
            else if(guess == 0)
            {
                hasLost = true;
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
        else if(userInput.equals("End Turn") || userInput.equals("end turn"))
        {
            boolean turn = turn(difficulty);

            if(turn)
            {
                hasLost = true;
            }
            else
            {

            }
        }
        //}else{
        //  turn(difficulty);
        //}
    }

    
    
    public static void menu()
    {
        String userInput = "";
        Scanner scan = new Scanner(System.in);

        if(hasLost || player.getNumGuesses() == 0)
        {
            System.out.println("GAME OVER");
        }
        else
        {
            System.out.println("\n");
            grid.drawGrid();
            System.out.println("\n");
            
            System.out.println("\nSelect one of the following options: ");
            System.out.println("Guess, Help, End Turn, or Quit");
            userInput = scan.next();
        }

        if(userInput.equals("Guess") || userInput.equals("guess"))
        {
            int guess = guess();

            if(guess == 1)
            {
                hasWon = true;
            }
            else if(guess == 0)
            {
                hasLost = true;
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
        else if(userInput.equals("End Turn") || userInput.equals("end turn"))
        {
            boolean turn = turn(difficulty);

            if(turn)
            {
                hasLost = true;
            }
            else
            {

            }
        }
    }

    //player makes a guess
    //will return 0, 1, or 2
    //0 if the player runs out of guesses to make
    //1 if the guess was correct
    //2 if the guess was wrong but the player hasn't run out of guesses
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

            grid.setPosOnGrid(xPos, yPos);
            
            if(opponent.checkGuess(xPos, yPos))
            {
                System.out.println("\nCorrect!");
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

    //will display information about the game and how to play
    public static void help()
    {

    }

    //the opponent turn
    public static boolean turn(String level)
    {
        int xPos = 0;
        int yPos = 0;

        //System.out.println(level);

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

        if(player.checkGuess(xPos, yPos))
        {
            System.out.println("You Lose");
            hasLost = true;
            return true;
        }
        else
        {
            System.out.println("The opponent did not guess correctly");
            return false;
        }

        //menu();
    }
}
