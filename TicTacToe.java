import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board =new char [3][3];
        for( int row = 0 ; row < board.length ; row++){
            for( int col = 0 ; col < board [row].length ; col ++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            if( isFull(board)){
                System.out.printf("Game is draw \nTry playing again for result");
                break;
            }
            System.out.println("Player " + player + " enter: ");
            int row = input.nextInt();
            int col = input.nextInt();
            if( board[row][col] == ' '){

                board[row][col] = player;
                gameOver = haveWon( board , player);
                if( gameOver){
                    printBoard(board);
                    System.out.println("Player " + player + " has won.");
                }
                else{
                    if( player == 'X'){
                        player = '0';
                    }
                    else{
                        player = 'X';
                    }
//                    player = (player == 'X') ? '0' : 'X';
                }
            }
            else{
                System.out.println("Invalid move. Try again!");
            }

        }

    }
    public static void printBoard(char[][] board){
        for( int row = 0 ; row < board.length ; row++){
            for( int col = 0 ; col < board [row].length ; col ++){
                System.out.print( board[row][col]  );
                if( col != 2){
                    System.out.print("|");
                }

            }
            System.out.println();
        }
    }

    public static boolean haveWon( char[][] board , char player){
//    checking rows
        for( int row = 0 ; row < board.length ; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

//        checking columns
        for( int col = 0 ; col < board[0].length ; col++){
            if( board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

//        checking diagonals
        if( board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if( board[0][2] == player && board[1][1] == player && board[0][2] == player){
            return true;
        }
        return false;
    }

    public static boolean isFull(char[][] board){
        boolean full = true;
        for( int row = 0 ; row < board.length ; row++){
            for( int col = 0 ; col < board[0].length ; col++){
                if( board[row][col] == ' '){
                    full = false;
                }
            }
        }
        return full;
    }
}
