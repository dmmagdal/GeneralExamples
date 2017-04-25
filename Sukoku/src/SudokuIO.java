import java.io.*;
import java.util.*;

public class SudokuIO {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// variable initialization
		Scanner in = new Scanner(new File("input.txt"));
		int linenum = 0;
		String[][] board = new String[11][9];
		
		// take in input from file and store to board[][]
		while (in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			for (int k = 0; k < input.length; k++){
				board[linenum][k] = input[k];
			}
			linenum++;
		}
		
		// print out board
		for (int j = 0; j < 11; j++){
			for (int l = 0; l < 9; l++){
				if (board[j][l].equals("0")){
					System.out.print("- ");
				}
				else {
					System.out.print(board[j][l]+" ");
				}
				if (l%3 == 0){
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		
		in.close();
	}
}
