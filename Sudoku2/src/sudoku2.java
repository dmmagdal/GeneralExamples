
public class sudoku2 {
	public void main(String[] args){
		int[][] grid = {{3,0,6,5,0,8,4,0,0},
				{5,2,0,0,0,0,0,0,0},
				{0,8,7,0,0,0,0,3,1},
				{0,0,3,0,1,0,0,8,0},
				{9,0,0,8,6,3,0,0,5},
				{0,5,0,0,9,0,6,0,0},
				{1,3,0,0,0,0,2,5,0},
				{0,0,0,0,0,0,0,7,4},
				{0,0,5,2,0,6,3,0,0}};
		
		if (solve(grid)){
			printGrid(grid);
		}
		else{
			System.out.println("No solution exists.");
		}
	}
	
	public boolean solve(int[][] arg){
		int[] l = {0, 0};
		
		if (!isEmpty(arg, l)){
			return true;
		}
		
		int row = l[0];
		int col = l[1];
		
		for (int i = 1; i < 10; i++){
			if (isSafe(arg, row, col, i)){
				arg[row][col] = i;
				if (solve(arg)){
					return true;
				}
				arg[row][col] = 0;
			}
		}
		return false;
	}
	
	public boolean isSafe(int[][] arg, int row, int col, int num){
		return !inRow(arg, row, num) && !inCol(arg, col, num) && !inSquare(arg, row, col, num);
	}
	
	public boolean inRow(int[][] arg, int row, int num){
		for (int i = 0; i < 9; i++){
			if (arg[row][i] == num){
				return true;
			}
		}
		return false;
	}
	
	public boolean inCol(int[][] arg, int col, int num){
		for (int i = 0; i < 9; i++){
			if (arg[i][col] == num){
				return true;
			}
		}
		return false;
	}
	
	public boolean inSquare(int[][] arg, int row, int col, int num){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (arg[i+row][j+col] == num){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEmpty(int[][] arg, int[] l){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (arg[i][j] == 0){
					l[0] = i;
					l[1] = j;
					return true;
				}
			}
		}
		return false;
	}
	
	public void printGrid(int[][] arg){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				System.out.print(arg[i][j]);
			}
			System.out.print("\n");
		}
	}
}
