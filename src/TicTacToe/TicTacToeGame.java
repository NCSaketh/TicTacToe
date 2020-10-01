package TicTacToe;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the TicTacToe Game");
        char board[]= CreateBoard();
	}
	
	public static char[] CreateBoard() {
		
		char[] board = new char[10];
		
		for(int i=0;i<10;i++)
		{
			board[i]= ' ';
		}
		
		return board;
	}

}
