import java.util.Scanner;

public class tictactoegame {
    
    // boards that will be used in the game to display information for the players
    // and to work with the bot
    static private String[] board = new String[9];
    static String[] X_board = new String[9];
    static String[] O_board = new String[9];

    // game checks to ensure the game does not go through problems
    static private boolean playerxwin = false;
    static private boolean playerowin = false;
    static private int Player_input;
    static private int check_move = 0;
    static private int turnscounter = 0;

    public static void tictactoegame() {
        
        Scanner in = new Scanner(System.in);

        // populates the board with numbers to show the player where they can input
        // through numbers
        for (int i = 0; i < board.length; i++) {
            board[i] = "" + (i + 1) + "";
        }

        // seperate board that is used for the medium bot
        for (int i = 0; i < X_board.length; i++) {
            X_board[i] = "" + (i + 1) + "";
        }

        for (int i = 0; i < O_board.length; i++) {
            O_board[i] = "" + (i + 1) + "";
        }


        int players;
        int difficulty = 0;

        // this is the main menu of the game where the player/players input their
        // options for the game
        System.out.println("************************************************************");
        System.out.println("\twelcome to TicTacToe!");
        System.out.println("please choose the number of players:");
        System.out.println("1. single player \t\t 2. VS");

        System.out.print("enter here: ");
        players = in.nextInt();

        if (players == 1) {
            System.out.println("select the difficulty: 1. easy \t2. medium");
            System.out.print("enter here: ");
            difficulty = in.nextInt();
        }

        printboard(board);

        do {
            try{
            gamemaster_medium gamemaster_medium = new gamemaster_medium(difficulty, turnscounter);

            // PlayerX turn input
            if (turnscounter < 9 && playerowin == false && playerxwin == false) {
                System.out.print("enter a number: ");
                Player_input = in.nextInt();

                do {

                        check_move = 0;
                        if (board[Player_input - 1] != "O" && board[Player_input - 1] != "X" && Player_input > 0 && Player_input < 10) {
                            board[Player_input - 1] = "X";
                            X_board[Player_input - 1] = "X";
                            turnscounter++;
                            check_move++;
                        }

                        else {
                            System.out.println("please enter a valid number on the board!");
                            System.out.print("enter a number: ");
                            Player_input = in.nextInt();
                            if (board[Player_input - 1] != "O" && board[Player_input - 1] != "X" && Player_input > 0 && Player_input < 10) {
                                board[Player_input - 1] = "X";
                                X_board[Player_input - 1] = "X";
                                turnscounter++;
                                check_move++;
                            }
                        }
                    

                    printboard(board);

                } while (check_move != 1);
            }

            checkwinner();

            // PlayerO's turn input

            // if the player wants the bot to load in
            if (turnscounter < 9 && playerowin == false && playerxwin == false) {
                if (players == 1) {

                    //easy bot
                    if (difficulty == 1) {
                        do {
                            double random = 1 + Math.random() * 9;
                            int rand_move = (int) random;
                            Player_input = rand_move;

                            if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 0 && Player_input < 10) {
                                board[Player_input - 1] = "O";
                                turnscounter++;
                                check_move++;
                            }

                            else {
                                random = 1 + Math.random() * 9;
                                rand_move = (int) random;
                                Player_input = rand_move;
                                if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 0 && Player_input < 10) {
                                    board[Player_input - 1] = "O";
                                    turnscounter++;
                                    check_move++;
                                }
                            }

                            printboard(board);
                        } while (check_move != 2);
                    }

                    //medium bot
                    if (difficulty == 2) {
                        do {
                            Player_input = gamemaster_medium.XO_botdecision();

                            System.out.println(gamemaster_medium.XO_botdecision());
                            System.out.println();

                            if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 1 && Player_input < 9) {
                                board[Player_input - 1] = "O";
                                O_board[Player_input - 1] = "O";
                                turnscounter++;
                                check_move++;
                            }

                            else {
                                double random = 1 + Math.random() * 9;
                                int rand_move = (int) random;
                                Player_input = rand_move;
                                if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 0 && Player_input < 10) {
                                    board[Player_input - 1] = "O";
                                    O_board[Player_input - 1] = "O";
                                    turnscounter++;
                                    check_move++;
                                }
                            }

                            printboard(board);

                        } while (check_move != 2);
                    }
                }

                //two player option
                if (players == 2) {
                    System.out.print("enter a number: ");
                    Player_input = in.nextInt();

                    do {
                            if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 0 && Player_input < 10) {
                                board[Player_input - 1] = "O";
                                turnscounter++;
                                check_move++;
                            }

                            else {
                                System.out.println("please enter a valid number on the board!");
                                System.out.print("enter a number: ");
                                Player_input = in.nextInt();
                                if (board[Player_input - 1] != "X" && board[Player_input - 1] != "O" && Player_input > 0 && Player_input < 10) {
                                    board[Player_input - 1] = "O";
                                    turnscounter++;
                                    check_move++;
                                }
                            }
                        
                        printboard(board);
                    } while (check_move != 2);
                }
                checkwinner();

            }
        }
            catch(Exception e){
                System.out.println("An error has occured due to incorrect input, please enter a correct entry");
                System.out.print("enter here: "); Player_input = in.nextInt();
            }
        } while (turnscounter < 9 && playerowin == false && playerxwin == false);

        if (playerowin == false && playerxwin == false)
            System.out.println("the game ended in a draw");

            
    }

    // prints the board
    public static void printboard(String[] board) {
        System.out.println("*************************************************************");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|---|---|---|");
    }

    // checks for winner mid game
    public static void checkwinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            // For X winner
            if (line.equals("XXX")) {
                System.out.println("1'st player won!");
                playerxwin = true;
            }

            // For O winner
            else if (line.equals("OOO")) {
                System.out.println("2'nd player won!");
                playerowin = true;
            }
        }
    }

    public void setPlayerxwin(boolean playerxwin) {
        this.playerxwin = playerxwin;
    }

    public boolean getPlayerxwin() {
        return playerxwin;
    }

    public void setPlayerowin(boolean playerowin) {
        this.playerowin = playerowin;
    }

    public boolean getPlayerowin() {
        return playerowin;
    }

    public void setTurnscounter(int turnscounter) {
        this.turnscounter = turnscounter;
    }
}
