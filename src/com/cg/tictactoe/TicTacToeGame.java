package com.cg.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);
	static char[] board = new char[10];
	public static final int HEAD = 0;
	public static final int TAIL = 1;
	static char userSymbol = inputXorO();
	static char pcSymbol = (userSymbol == 'X') ? 'O' : 'X';
	static int index = 0;
	static char input = ' ';

	public static void main(String[] args) {

		Tossing();
		board = createBoard();
		// inputXorO();
		showBoard(board);
		userMove(board, input);
		// makeMove(board, index, input);
		pcMove(board);
		gameStatus(board, input);
		blockUser(board);
		cornerMove(board);
		showBoard(board);

	}

	// UC1 :Creating TicTacToe board
	public static char[] createBoard() {

		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	// UC2 :Player choose input X or O
	public static char inputXorO() {
		System.out.println("Welcome to the TicTacToe Game");
		System.out.println("Choose X or O");
		char input = Character.toUpperCase(sc.next().charAt(0));

		if (input == 'X' || input == 'O') {

			return input;

		} else
			System.out.println("Invalid input");

		return inputXorO();
	}

	// UC3 : Displaying Current Board
	public static void showBoard(char[] board) {
		System.out.println("Current Board Display:");

		System.out.println("   " + board[1] + "|  " + board[2] + "|" + board[3]);
		System.out.println("------------- ");
		System.out.println("   " + board[4] + "|  " + board[5] + "|" + board[6]);
		System.out.println("------------- ");
		System.out.println("   " + board[7] + "|  " + board[8] + "|" + board[9]);

	}

	// UC4 :Selecting Index and ensuring the index is free
	private static void userMove(char board[], char input) {

		// do {
		System.out.println("select index between 1-9");
		index = sc.nextInt();
		sc.nextLine();

		if (isFreeIndex(board, index) == false) {

			System.out.println("Index already filled");
			userMove(board, input);
		} else if (index < 1 || index > 9) {
			System.out.println("Invalid Index choice! Enter again");
			userMove(board, input);
		} else {
			board[index] = userSymbol;
			showBoard(board);
		}

		// } while (board[index] != ' ');

		// return showBoard(board);
	}

	private static boolean isFreeIndex(char board[], int index) {
		if (board[index] == 'X' || board[index] == 'O')
			return false;
		else
			return true;
	}

	// UC5: Checking if the index is free to make move
	private static void makeMove(char[] board, int index, char input) {
		boolean FreeIndex = isFreeIndex(board, index);
		if (FreeIndex)
			board[index] = input;
	}

	// UC6 : Toss to check who starts first
	private static int Tossing() {
		int toss = (int) Math.floor(Math.random() * 2);
		if (toss == 0)
			System.out.println("User won the toss");
		else
			System.out.println("Computer won the toss");
		return toss;
	}

	// UC7 : Checking if anyone has won or game tied or change turn
	private static int gameStatus(char board[], char Symbol) {
		if ((board[1] == Symbol && board[2] == Symbol && board[3] == Symbol)
				|| (board[4] == Symbol && board[5] == Symbol && board[6] == Symbol)
				|| (board[7] == Symbol && board[8] == Symbol && board[9] == Symbol)
				|| (board[1] == Symbol && board[4] == Symbol && board[7] == Symbol)
				|| (board[2] == Symbol && board[5] == Symbol && board[8] == Symbol)
				|| (board[3] == Symbol && board[6] == Symbol && board[9] == Symbol)
				|| (board[1] == Symbol && board[5] == Symbol && board[9] == Symbol)
				|| (board[3] == Symbol && board[5] == Symbol && board[7] == Symbol)) {
			if (Symbol == userSymbol)
				System.out.println("User has won the game.");
			else
				System.out.println("Computer has won the game.");
			return -1;
		}
		for (int index = 1; index < board.length; index++)
			if (isFreeIndex(board, index) == true) {
				if (Symbol == userSymbol)
					System.out.println("Computer's turn.");
				else
					System.out.println("User's turn.");
				return 0;
			}
		System.out.println("Game tied");
		showBoard(board);
		return 1;
	}

	// UC8 : Computer makes its move at the best spot
	private static void pcMove(char board[]) {

		if (board[1] == pcSymbol && board[2] == pcSymbol && board[3] == ' ')
			board[3] = pcSymbol;
		else if (board[1] == pcSymbol && board[2] == ' ' && board[3] == pcSymbol)
			board[2] = pcSymbol;
		else if (board[1] == ' ' && board[2] == pcSymbol && board[3] == pcSymbol)
			board[1] = pcSymbol;
		else if (board[4] == pcSymbol && board[5] == pcSymbol && board[6] == ' ')
			board[6] = pcSymbol;
		else if (board[4] == pcSymbol && board[5] == ' ' && board[6] == pcSymbol)
			board[5] = pcSymbol;
		else if (board[4] == ' ' && board[5] == pcSymbol && board[6] == pcSymbol)
			board[4] = pcSymbol;
		else if (board[7] == pcSymbol && board[8] == pcSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[7] == pcSymbol && board[8] == ' ' && board[9] == pcSymbol)
			board[8] = pcSymbol;
		else if (board[7] == ' ' && board[8] == pcSymbol && board[9] == pcSymbol)
			board[7] = pcSymbol;
		else if (board[1] == pcSymbol && board[4] == pcSymbol && board[7] == ' ')
			board[7] = pcSymbol;
		else if (board[1] == pcSymbol && board[4] == ' ' && board[7] == pcSymbol)
			board[4] = pcSymbol;
		else if (board[1] == ' ' && board[4] == pcSymbol && board[7] == pcSymbol)
			board[1] = pcSymbol;
		else if (board[2] == pcSymbol && board[5] == pcSymbol && board[8] == ' ')
			board[8] = pcSymbol;
		else if (board[2] == pcSymbol && board[5] == ' ' && board[8] == pcSymbol)
			board[5] = pcSymbol;
		else if (board[2] == ' ' && board[5] == pcSymbol && board[8] == pcSymbol)
			board[2] = pcSymbol;
		else if (board[3] == pcSymbol && board[6] == pcSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[3] == pcSymbol && board[6] == ' ' && board[9] == pcSymbol)
			board[6] = pcSymbol;
		else if (board[3] == ' ' && board[6] == pcSymbol && board[9] == pcSymbol)
			board[3] = pcSymbol;
		else if (board[1] == pcSymbol && board[5] == pcSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[1] == pcSymbol && board[5] == ' ' && board[9] == pcSymbol)
			board[5] = pcSymbol;
		else if (board[1] == ' ' && board[5] == pcSymbol && board[9] == pcSymbol)
			board[1] = pcSymbol;
		else if (board[3] == pcSymbol && board[5] == pcSymbol && board[7] == ' ')
			board[7] = pcSymbol;
		else if (board[3] == pcSymbol && board[5] == ' ' && board[7] == pcSymbol)
			board[5] = pcSymbol;
		else if (board[3] == ' ' && board[5] == pcSymbol && board[7] == pcSymbol)
			board[3] = pcSymbol;
		else {
			if (blockUser(board) == 'N')
				cornerMove(board);
		}
	}

	// UC9:Blocking User winning chance
	private static char blockUser(char board[]) {
		if (board[1] == userSymbol && board[2] == userSymbol && board[3] == ' ')
			board[3] = pcSymbol;
		else if (board[1] == userSymbol && board[2] == ' ' && board[3] == userSymbol)
			board[2] = pcSymbol;
		else if (board[1] == ' ' && board[2] == userSymbol && board[3] == userSymbol)
			board[1] = pcSymbol;
		else if (board[4] == userSymbol && board[5] == userSymbol && board[6] == ' ')
			board[6] = pcSymbol;
		else if (board[4] == userSymbol && board[5] == ' ' && board[6] == userSymbol)
			board[5] = pcSymbol;
		else if (board[4] == ' ' && board[5] == userSymbol && board[6] == userSymbol)
			board[4] = pcSymbol;
		else if (board[7] == userSymbol && board[8] == userSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[7] == userSymbol && board[8] == ' ' && board[9] == userSymbol)
			board[8] = pcSymbol;
		else if (board[7] == ' ' && board[8] == userSymbol && board[9] == userSymbol)
			board[7] = pcSymbol;
		else if (board[1] == userSymbol && board[4] == userSymbol && board[7] == ' ')
			board[7] = pcSymbol;
		else if (board[1] == userSymbol && board[4] == ' ' && board[7] == userSymbol)
			board[4] = pcSymbol;
		else if (board[1] == ' ' && board[4] == userSymbol && board[7] == userSymbol)
			board[1] = pcSymbol;
		else if (board[2] == userSymbol && board[5] == userSymbol && board[8] == ' ')
			board[8] = pcSymbol;
		else if (board[2] == userSymbol && board[5] == ' ' && board[8] == userSymbol)
			board[5] = pcSymbol;
		else if (board[2] == ' ' && board[5] == userSymbol && board[8] == userSymbol)
			board[2] = pcSymbol;
		else if (board[3] == userSymbol && board[6] == userSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[3] == userSymbol && board[6] == ' ' && board[9] == userSymbol)
			board[6] = pcSymbol;
		else if (board[3] == ' ' && board[6] == userSymbol && board[9] == userSymbol)
			board[3] = pcSymbol;
		else if (board[1] == userSymbol && board[5] == userSymbol && board[9] == ' ')
			board[9] = pcSymbol;
		else if (board[1] == userSymbol && board[5] == ' ' && board[9] == userSymbol)
			board[5] = pcSymbol;
		else if (board[1] == ' ' && board[5] == userSymbol && board[9] == userSymbol)
			board[1] = pcSymbol;
		else if (board[3] == userSymbol && board[5] == userSymbol && board[7] == ' ')
			board[7] = pcSymbol;
		else if (board[3] == userSymbol && board[5] == ' ' && board[7] == userSymbol)
			board[5] = pcSymbol;
		else if (board[3] == ' ' && board[5] == userSymbol && board[7] == userSymbol)
			board[3] = pcSymbol;
		else
			return 'N';
		return 'Y';
	}

	//UC10 : PC makes corner moves if any corner is free
	private static char cornerMove(char board[]) {
		if (isFreeIndex(board, 1) == true)
			board[1] = pcSymbol;
		else if (isFreeIndex(board, 3) == true)
			board[3] = pcSymbol;
		else if (isFreeIndex(board, 7) == true)
			board[7] = pcSymbol;
		else if (isFreeIndex(board, 9) == true)
			board[9] = pcSymbol;
		else
			return 'N';
		return 'Y';

	}
}
