import java.io.*;
import java.util.*;

public class Sudoku {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// variable initialization
		Scanner in = new Scanner(new File("input.txt"));
		int linenum = 0;
		String[][] board = new String[11][9];
		boolean filled = true;
		
		// take in input from file and store to board[][]
		while (in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			if (input[0] == null){
				continue;
			}
			else{
				for (int k = 0; k < input.length; k++){
					board[linenum][k] = input[k];
				}
				linenum++;
			}
		}
		
		// print initial state of puzzle
		print(board, filled);
		
		// working on solving the puzzle
		while (finished(board, filled) == false){
			
			/*
			bynumber(board);
			bysquare(board);
			byrow(board);
			bycol(board);
			*/
		}
		
		// print final state of board
		print(board, filled);
		
		in.close();
	}
	
	public static void print(String[][] board, boolean filled){
		// print out board
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
					else {
						System.out.print(board[j][l]+" ");
					}
					if (l == 2 || l == 5){
						System.out.print("  ");
					}
				}
			}
			System.out.print("\n");
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
