package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the TicTacToe Game");
		char board[] = createBoard();
		inputXorO();
	}

	/**
	 * Creating Tic Tac Toe board
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

	public static void inputXorO() {
		Scanner sc = new Scanner(System.in);
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

}
