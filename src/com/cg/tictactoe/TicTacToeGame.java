package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the TicTacToe Game");
		char board[] = createBoard();
		inputXorO();
		showBoard(board);
	}

	/**
	 * Creating TicTacToe board
	 * 
	 * @return
	 */
	public static char[] createBoard() {

		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * Player choose input X or O
	 */
	public static void inputXorO() {
		System.out.println("Choose X or O");
		String input = sc.next();

		if (input.equals("X") || input.equals("x")) {
			System.out.println("Letter of the player is X");
			System.out.println("Letter of the computer is O");
		} else if (input.equals("O") || input.equals("o")) {
			System.out.println("Letter of the player is O");
			System.out.println("Letter of the computer is X");
		} else {
			System.out.println("Invalid input");
			inputXorO();
		}

	}
	
	public static void showBoard(char[] board) {
		System.out.println("Current Board Display:");
		
		System.out.println("   " + board[1] + "|  " + board[2] + "|" + board[3] );
		System.out.println("------------- ");
		System.out.println("   " + board[4] + "|  " + board[5] + "|" + board[6] );
		System.out.println("------------- ");
		System.out.println("   " + board[7] + "|  " + board[8] + "|" + board[9] );
		
		}
		
	
	
	

}
