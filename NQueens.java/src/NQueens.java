import java.io.*;
import java.util.Scanner;

public class NQueens {

	// Global variable Board and board size
	private static int size;
	private static boolean[][] Board;

	public static void main(String[] args) throws IOException{ 
		// Initialize variables
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("Solutions"));

		// Check to be sure if there are correct number of command line
		// arguments
		int cmdlnarg = args.length;
		if (cmdlnarg < 3){
			System.out.println("Usage: java -jar NQueens.jar <board size> <x coordinate> <y coordinate> ");
			System.exit(1);
		}
			
		size = Integer.parseInt(args[0]);
		
		// Initialize board
		Board = new boolean[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				Board[i][j] = false;
			}
		}

		//Place queen from command line arguments
		int x = Integer.parseInt(args[1]) -1, y = Integer.parseInt(args[2]) -1;
		Board[x][y] = true;

		// Call recursive algorithm
		boolean SolutionExist = isASolution(size-1, x, y);

		// Print out updated board if solution exits
		// and to file solutions
		if (SolutionExist == true){
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					if (Board[i][j] == true){
						System.out.println((i+1)+", "+(j+1));
						out.println((i+1)+", "+(j+1));
					}
				}
			}
		}
		// Response to "No solution" scenario 
		else{
			System.out.println("No Solution");
			out.println("No Solution");
		}

		in.close();
		out.close();

	}

	public static boolean isASolution(int x, int userX, int userY){
		int i = 0; // increment variable
		
		// Base case
		if (x == 0){
			// Check for any free spaces in column n at base case
			while (i < size){
				if (freeSquare(x, i, userX, userY) == false){
					i++;
				}
				else{
					Board[x][i] = true;
					return true;
				}
				// if statement for if there are no solutions for the column
				if (i == size-1 && freeSquare(x, i, userX, userY) == false){
					return false;
				}
			}
		}
		
		// Place queen in free square, if no free 
		// exists, return false
		while (i < size){
			if (freeSquare(x, i, userX, userY) == false){
				i++;
			}
			else{
				Board[x][i] = true;
				// since there is a true value, i'll call isASolution again
				// to see where this branches off to.
				if (isASolution(x-1, userX, userY) == false){
					Board[x][i] = false;
					i++;
				}
			}
			
			// if statement for if there are no solutions for the column
			if (i == size-1 && freeSquare(x, i, userX, userY) == false){
				return false;
			}
		}
		return false;
	}
	
	// Tells if the square is free without being attacked
	// Uses n as col (x) and p as row (y)
	// o is the user entered col and q is user entered row 
	public static boolean freeSquare(int x, int y, int userX, int userY){
		// If the column is the same as the input column, the 
		// function returns true
		if (x == userX){
			y = userY;
			return true;
		}
		// If queen exists without conflict
		// Board has a true value. If conflict exists, 
		// returns false ("there is no free square").
		
		// Column and row check
		for (int i = 0; i < size; i++){
			
			// Check row for conflict
			if (Board[i][y] == true){
				return false;
			}
			// Check column for conflict
			if (Board[x][i] == true){
				return false;
			}
			
		}
		
		// Diagonal check
		// 
		// Right diagonal
		while (x != size-1){ //for when x isn't the piece against the wall of the board
			for (int r = x+1; r < size; r++){
				// Upward
				for (int u = y+1; u < size; u++){
					if (Board[r][u] == true){
						return false;
					}
				}
				// Downward
				for (int d = y-1; d >= 0 ; d--){
					if (Board[r][d] == true){
						return false;
					}
				}
			}
		}
		
		// Left diagonal
		while (x != 0){ //for when x isn't the piece against the wall of the board
			for (int l = x-1; l > 0; l--){
				// Upward
				for (int u = y+1; u < size; u++){
					if (Board[l][u] == true){
						return false;
					}
				}
				// Downward
				for (int d = y-1; d >= 0; d--){
					if (Board[l][d] == true){
						return false;
					}
				}
			}
		}
		return true;
	}

}
