package solver;
import java.util.Scanner;

// TODO: Add a GUI

public class Sudoku {
    public static void main(String args[]) {
    	// Read a Sudoku puzzle
    	int[][] grid = readAPuzzle();
    	
    	if(!isValid(grid)) {
    		System.out.println("I AM ERROR: Invalid Input");
    	} else if (search(grid)) {
    		System.out.println(); // print empty line
    		System.out.println("The solution is found: ");
    	    printGrid(grid);
    	} else {
    		System.out.println("No solution");
    	}
    }
    
    /** Read a Sudoku puzzle from the keyboard */
    public static int[][] readAPuzzle() {
    	// Create a scanner
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Enter a Sudoku Puzzle: ");
    	int[][] grid = new int[9][9];
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			grid[i][j] = input.nextInt();
    		}
    	}
    	input.close();
    	return grid;
    }
    
    /** Obtain a list of free cells from the puzzle */
    public static int [][] getFreeCellList(int[][] grid) {
    	// Determine the number of free cells
    	int numberOfFreeCells = 0;
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (grid[i][j] == 0) {
    				numberOfFreeCells++;
    			}
    		}
    	}
    	
    	// Store free cell positions into freeCellList
    	// the rows are as long as the number of free cells
    	// that exist. The returned list is a 2D array that
    	// holds the i and j values needed to index the free
    	// cell that was entered into the program.
    	int[][] freeCellList = new int[numberOfFreeCells][2];
    	int count = 0;
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (grid[i][j] == 0) {
    				// Stores i, j as an array in an array
    				freeCellList[count][0] = i;
    				freeCellList[count++][1] = j;
    			}
    		}
    	}
    	return freeCellList;
    }
    
    /** Print the values in the grid */
    public static void printGrid(int[][] grid) {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(grid[i][j] + " ");
    		}
    		System.out.println();    	
    	}
    }
    
    /** Search for a solution */
    public static boolean search(int[][] grid) {
    	int[][] freeCellList = getFreeCellList(grid); // Free Cells
    	int k = 0; // Start from the first free cell
    	boolean found = false; // Solution found?
    	
    	while (!found) {
    		int i = freeCellList[k][0];
    		int j = freeCellList[k][1];
    		if(grid[i][j] == 0) {
    			grid[i][j] = 1; // Start with 1
    		}
    		
    		if (isValid(i, j, grid)) {
    			// When K reaches the end of a row, the solution is found
    			if (k + 1 == freeCellList.length) { // No more free cells
    				found = true; // A solution is found
    			} else { // Move to the next free cell
    				k++; 
    			}
    		} else if (grid[i][j] < 9) {
    			grid[i][j] = grid[i][j] + 1; // Check the next possible value
    		} else { // grid[i][j] is 9: backtrack
    			while (grid[i][j] == 9) {
    				// Can no longer increment, so make 0
    				grid[i][j] = 0; // Reset to free cell
    				if( k == 0) {
    					// K has reached all the way to 
    					// the beginning of the freeCellList row
    					// when this happens, there is no answer.
    					return false; // No possible value
    				}
    				k--; // Backtrack
    				i = freeCellList[k][0];
    				j = freeCellList[k][1];
    			}
    			
    			// Check the next highest value <= nine to see if it works
    			grid[i][j] = grid[i][j] + 1; // Check the next possible value
    		}
    	}
    	
    	return true; // A solution is found
    }
    
    /** Check whether grid[i][j] is valid in the grid */
    public static boolean isValid(int i, int j, int[][] grid) {
    	// Check whether grid [i][j] is valid at the i's row
    	// Numbers 1-9 with no duplicates can be present
    	for (int column = 0; column < 9; column++) {
    		if (column != j && grid[i][column] == grid[i][j]) {
    			return false;
    		}
    	}
    	
    	// Check whether grid[i][j] is valid at the j's column
    	// Numbers 1-9 with no duplicates can be present
    	for (int row = 0; row < 9; row++) {
    		if (row != i && grid[row][j] == grid[i][j]) {
    			return false;
    		}
    	}
    	
    	// Check whether grid[i][j] is valid in the 3 by 3 box
    	// The floor result from integer division is used to check
    	// only the square we are interested in.
    	for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
    		for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
    			if (row != i && col != j && grid[row][col] == grid[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true; // The current value at grid[i][j] is valid
    }
    
    /** Check whether the fixed cells are valid in the grid */
    public static boolean isValid(int[][] grid) {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (grid[i][j] != 0 && !isValid(i, j, grid)) {
    				return false;
    			}
    		}
    	}
    	return true; // The fixed cells are valid
    }
}
