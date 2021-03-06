import java.io.*;
import java.util.*;

public class Sudoku {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// variable initialization
		Scanner in = new Scanner(new File("input.txt"));
		int linenum = 0;
		String[][] Board = new String[11][9];
		int[][] board = new int[9][9];
		boolean filled = true;
		
		// take in input from file and store to board[][]
		while (in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			if (input[0] == null){
				continue;
			}
			else{
				for (int k = 0; k < input.length; k++){
					Board[linenum][k] = input[k];
				}
				linenum++;
			}
		}
		
		board = convert(Board);
		
		// print initial state of puzzle
		print(board, filled);
		
		if (solve(board) == true){
			print(board, filled);
		}
		else{
			System.out.print("No solution exists");
		}
		
		/*
		// working on solving the puzzle
		while (finished(board, filled) == false){
			bynumber(board);
			bysquare(board);
			byrow(board);
			bycol(board);
			
		}
		*/
		
		// print final state of board
		// print(board, filled);
		
		in.close();
	}
	
	public static int[][] convert(String[][] Board){
		int[][] board = new int[9][9];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 9; j++){
				board[i][j] = Integer.parseInt(Board[i][j]);
			}
		}
		for (int k = 4; k < 7; k++){
			for (int l = 0; l < 9; l++){
				board[k-1][l] = Integer.parseInt(Board[k][l]);
			}
		}
		for (int m = 8; m < 11; m++){
			for (int n = 0; n < 9; n++){
				board[m-2][n] = Integer.parseInt(Board[m][n]);
			}
		}
		
		return board;
	}
	
	public static void print(int[][] board, boolean filled){
		// print out board
		for (int j = 0; j < 9; j++){
			for (int l = 0; l < 9; l++){
				if (board[j][l] == 0){
					filled = false;
					System.out.print("- ");
				}
				else {
					System.out.print(board[j][l]+" ");
				}
				if (l == 2 || l == 5){
					System.out.print("  ");
				}
			}
			System.out.print("\n");
			if (j == 2 || j == 5){
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		if (filled == false){
			System.out.println("The puzzle is not filled.");
		}
		else {
			System.out.println("The puzzled is filled.");
		}
	}
	
	public static boolean finished(String[][] board, boolean filled){
		// Scan for "empty" slots
		for (int j = 0; j < 11; j++){
			for (int l = 0; l < 9; l++){
				if (board[j][l] == null){
					continue;
				}
				else {
					if (board[j][l].equals("0")){
						filled = false;
						System.out.print("- ");
					}
				}
			}
		}
		return filled;
	}
	
	public static boolean solve(int[][] board){
		int row, col;
		
		// Base case: if there are no unassigned locations 
		// (Puzzle is solved), the program is done.
		if (!findempty(board)){
			return true; 
		}
		
		row = 0;
		col = 0;
		
		// scan through digits 1-9
		for (int num = 1; num <= 9; num++){
			// if the area is promising
			if (issafe(board, row, col, num)){
				// temporary assignment
				board[row][col] = num;
				
				// if recursive call returns true, the 
				// assignment sticks
				if (solve(board)){
					return true;
				}
				
				// otherwise, the space is returned to 0
				board[row][col] = 0;
			}
		}
		return false; // start backtracking
	}
	
	public static boolean findempty(int[][] board){
		// scans the board for 0 (empty) slots
		for (int row = 0; row < 9; row++){
			for (int col = 0; col < 9; col++){
				if (board[row][col] == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean issafe(int[][] board, int row, int col, int num){
		// check to make sure that num is not already in current row,
		// col, or box
		return !inrow(board, row, num) && !incol(board, col, num) && !inbox(board, row-row%3, col-col%3, num);
	}
	
	public static boolean inrow(int[][] board, int row, int num){
		// check to see if num already exists in current row
		for (int col = 0; col < 9; col++){
			if (board[row][col] == num){
				return true;
			}
		}
		return false;
	}
	
	public static boolean incol(int[][] board, int col, int num){
		// check to see if num already exists in current col
		for (int row = 0; row < 9; row++){
			if (board[row][col] == num){
				return true;
			}
		}
		return false;
	}
	
	public static boolean inbox(int[][] board, int startrow, int startcol, int num){
		// check to see if num already exists in current box
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				if (board[row+startrow][col+startcol] == num){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	/*
	public static String[][] bynumber(String[][] board){
		int counter = 0;
		int num = 1;
		for (int i = 1; i < 10; i++){
					}
		return board;
	}
	
	public static String[][] bysquare(String[][] board){
		
		return board;
	}
	
	public static String[][] byrow(String[][] board){
		for (int i = 0; i < 11; i++){
			
		}
		return board;
	}
	
	public static String[][] bycol(String[][] board){
		
		return board;
	}
	*/
}
