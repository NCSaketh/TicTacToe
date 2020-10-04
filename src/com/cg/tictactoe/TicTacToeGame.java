package com.cg.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);
	static char[] board = new char[10];
	public static final int HEAD = 0;
	public static final int TAIL = 1;

	public static enum Player {
		USER, COMPUTER
	};

	static int index = 0;
	static char input = ' ';

	public static enum Player1 {
		USER, COMPUTER
	};

	public static void main(String[] args) {
		System.out.println("Welcome to the TicTacToe Game");
		

		board = createBoard();
		inputXorO();
		showBoard(board);
		userMove(board, input);
		makeMove(board, index, input);
		//Player player1 = getWhoStartFirst();

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

		//do {
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
				board[index] = inputXorO();
				showBoard(board);
			}

		//} while (board[index] != ' ');

		//return showBoard(board);
	}

	private static boolean isFreeIndex( char board[], int index) {
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
	private static int  Tossing() {
		int toss = (int) Math.floor(Math.random() * 2);
		return toss;
	}

}
