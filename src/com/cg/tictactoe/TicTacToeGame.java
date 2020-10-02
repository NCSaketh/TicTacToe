package com.cg.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);
	public static final int HEAD = 0;
	public static final int TAIL = 1;
	public static enum Player{USER, COMPUTER};
	static int indexChoice=0;
	static char input = ' ';

	public static void main(String[] args) {
		System.out.println("Welcome to the TicTacToe Game");
		
		char board[] = createBoard();
		inputXorO();
		showBoard(board);		
		makePlayerMove(board, input);
		makeMove(board,indexChoice, input);
		
		
	}
	
	
	//UC1 :Creating TicTacToe board
	public static char[] createBoard() {

		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	
	 // UC2 :Player choose input X or O	 
	public static char inputXorO() {
		System.out.println("Choose X or O");
		char input = sc.next().charAt(0);	

		if (input == 'X' || input == 'x') {
			System.out.println("Letter of the player is X");
			System.out.println("Letter of the computer is O");
			
		} else if (input == 'O' || input == 'o') {
			System.out.println("Letter of the player is O");
			System.out.println("Letter of the computer is X");
			
		} else {
			System.out.println("Invalid input");
			inputXorO();
			
		}
       return input;
	}

	//UC3 : Displaying Current Board
	public static void showBoard(char[] board) {
		System.out.println("Current Board Display:");

		System.out.println("   " + board[1] + "|  " + board[2] + "|" + board[3]);
		System.out.println("------------- ");
		System.out.println("   " + board[4] + "|  " + board[5] + "|" + board[6]);
		System.out.println("------------- ");
		System.out.println("   " + board[7] + "|  " + board[8] + "|" + board[9]);

	}
	
	//UC4 :Selecting Index and ensuring the index is free
	private static void makePlayerMove(char board[], char inputXorO)
	{
		
		do {
			System.out.println("select index between 1-9");
			indexChoice = sc.nextInt();
			sc.nextLine();
			if(isFreeIndex(indexChoice,board)== false)
				System.out.println("Index already filled");
			else {
				board[indexChoice] = input;
				return;
			   }
				
		} while(board[indexChoice]!= ' ');
	}
	
	private static boolean isFreeIndex(int indexChoice, char board[])
	{
		if(board[indexChoice] == 'X' || board[indexChoice] == 'O')
			return false;
		else
			return true;
	}
	
	//UC5: Checking if the index is free to make move
   private static void makeMove(char[] board, int indexChoice, char input) {
	   boolean FreeIndex = isFreeIndex(indexChoice,board);
	   if(FreeIndex) 
		   board[indexChoice] = input;
   }
}
