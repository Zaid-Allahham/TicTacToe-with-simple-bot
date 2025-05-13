import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        //necessary inputs and variables to loop the game and count the number of times the game is played
        Scanner in = new Scanner(System.in);
        int times_played = 0;
        int times_X_won = 0;
        int times_O_won = 0;
        boolean play_again = false;
        tictactoegame game = new tictactoegame();
        
        //the game loop to make sure the game loops and resets every time the player wants to play again
        do{
            times_played++;
            game.tictactoegame();

            if(game.getPlayerowin() == true)
            times_O_won++;
            else if(game.getPlayerxwin() == true)
            times_X_won++;

            System.out.println("*************************************************************");
            System.out.println("would you like to play again?\n ->if so then please enter 1; if no, then enter 2");
            for(boolean i = false; i != true;){
            System.out.print("enter here: "); int again = in.nextInt();

            switch (again) {
                case 1:
                    play_again = true;
                    game.setPlayerowin(false);
                    game.setPlayerxwin(false);
                    game.setTurnscounter(0);
                    i = true;
                    break;

                case 2:
                    play_again = false;
                    i = true;
                    break;
                
                default:
                    System.out.println("***please enter a valid number***");
            }}
            if(play_again == false)
            break;
        }while(play_again);

        System.out.println("*************************************************************");
        System.out.println("the number of times you played the game is: " + times_played);
        System.out.println("the number of times player X won the game is: " + times_X_won);
        System.out.println("the number of times player O won the game is: " + times_O_won);

    }
}