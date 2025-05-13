public class gamemaster_medium extends gamemaster{
    private int  turn2;

    gamemaster_medium(int difficulty, int turnscounter){
        if(difficulty == 2 && turnscounter == 0)
        System.out.println("gamemaster medium loaded in succesfully");
    }

    public int XO_botdecision(){
        return XO_bot();
    }

    int XO_bot() {
        String [] board = tictactoegame.X_board;
    
        String [] boardO =  tictactoegame.O_board;

        //This code checks for any chances for the bot to win and inputs the correct number on the board

            String check_for_win = boardO[0] + boardO[1] + boardO[2] + boardO[3] + boardO[4] + boardO[5] + boardO[6] + boardO[7] + boardO[8];
            boolean finish = false;

            switch (check_for_win){
                case "1OO456789" : turn2 = 1; finish = true; break;
                case "123O56O89" : turn2 = 1; finish = true;break;
                case "1234O678O" : turn2 = 1; finish = true;break;
                case "O2O456789" : turn2 = 2; finish = true;break;
                case "1234O67O9" : turn2 = 2; finish = true;break;
                case "OO3456789" : turn2 = 3; finish = true;break;
                case "1234O6O89" : turn2 = 3; finish = true;break;
                case "12345O78O" : turn2 = 3; finish = true;break;
                case "1234OO789" : turn2 = 4; finish = true;break;
                case "O23456O89" : turn2 = 4; finish = true;break;
                case "123O5O789" : turn2 = 5; finish = true;break;
                case "O2345678O" : turn2 = 5; finish = true;break;
                case "1O34567O9" : turn2 = 5; finish = true;break;
                case "12O456O89" : turn2 = 5; finish = true;break;
                case "123OO6789" : turn2 = 6; finish = true;break;
                case "12O45678O" : turn2 = 6; finish = true;break;
                case "1234567OO" : turn2 = 7; finish = true;break;
                case "O23O56789" : turn2 = 7; finish = true;break;
                case "12O4O6789" : turn2 = 7; finish = true;break;
                case "123456O8O" : turn2 = 8; finish = true;break;
                case "1O34O6789" : turn2 = 8; finish = true;break;
                case "123456OO9" : turn2 = 9; finish = true;break;
                case "12O45O789" : turn2 = 9; finish = true;break;
                case "O234O6789" : turn2 = 9; finish = true;break;
            }

            //This checks all the possible inputs for the user in turn 1 and turn 3 so he can choose the correct one in turns 2 and 4
            
            if (finish == false){
            
            String line = board[0] + board[1] + board[2] + board[3] + board[4] + board[5] + board[6] + board[7] + board[8];
            switch (line) {

                /****TURN2****/
                //number 1 check
                case "X23456789" : turn2 = 3; break;
                //number 2 check
                case "1X3456789" : turn2 = 1; break;
                //number 3 check
                case "12X456789" : turn2 = 1; break;
                //number 4 check
                case "123X56789" : turn2 = 1; break;
                //number 5 check
                case "1234X6789" : turn2 = 1; break;
                //number 6 check
                case "12345X789" : turn2 = 1; break;
                //number 7 check
                case "123456X89" : turn2 = 3; break;
                //number 8 check
                case "1234567X9" : turn2 = 1; break;
                //number 9 check
                case "12345678X" : turn2 = 3; break;

                /****TURN4****/
                case "1XX456789" : turn2 = 1; break;
                case "123X56X89" : turn2 = 1; break;
                case "1234X678X" : turn2 = 1; break;
                case "X2X456789" : turn2 = 2; break;
                case "1234X67X9" : turn2 = 2; break;
                case "XX3456789" : turn2 = 3; break;
                case "1234X6X89" : turn2 = 3; break;
                case "12345X78X" : turn2 = 3; break;
                case "X23456X89" : turn2 = 4; break;
                case "1234XX789" : turn2 = 4; break;
                case "X2345678X" : turn2 = 5; break;
                case "12X456X89" : turn2 = 5; break;
                case "1X34567X9" : turn2 = 5; break;
                case "123X5X789" : turn2 = 5; break;
                case "12X45678X" : turn2 = 6; break;
                case "123XX6789" : turn2 = 6; break;
                case "X23X56789" : turn2 = 7; break;
                case "12X4X6789" : turn2 = 7; break;
                case "1234567XX" : turn2 = 7; break;
                case "1X34X6789" : turn2 = 8; break;
                case "123456X8X" : turn2 = 8; break;
                case "12X45X789" : turn2 = 9; break;
                case "X234X6789" : turn2 = 9; break;
                case "123456XX9" : turn2 = 9; break;

                /****TURN6****/
                //case "1XX4X6789" : turn2 = 7; break;
                //case "1XX45X789" : turn2 = 9; break;
                //case "1XX456X89" : turn2 = 5; break;
                //case "1XX45678X" : turn2 = 6; break;
                //case "1XX4X6789" : turn2 = 8; break;
                //case "1XX4567X9" : turn2 = 5; break;
                //case "123X56X89" : turn2 = 1; break;
                

                default : 
                double random = 1 + Math.random() * 9;
                int rand_move = (int) random;
                turn2 = rand_move;;
            }
    }
        
            
        return turn2;
    }

}
