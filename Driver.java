import java.util.*;

public class Driver {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); // scanner for reading in user input

		// boolean control variables
		boolean spanningTrees; // set to true if the user wishes to calculate spanning trees
        boolean repeat = true; // will repeat by default
		
        while (repeat) {
    		System.out.println("Please choose an option (1 or 2): \n"
    				+ "1) Calculate the number of spanning trees of a graph \n"
    				+ "2) Calculate the determinant of a matrix");
        	spanningTrees = scan.nextInt() == 1;
    		
			// Prompt user to input size of matrix
			if(spanningTrees) // option 1
				System.out.println("How many vertices are in the graph?");
			else // option 2 (determinant)
				System.out.println("What is the degree of the NxN matrix?");
			int size = scan.nextInt();
			
			// Prompt user to input entries in [size][size] matrix
			if(spanningTrees) // option 1
				System.out.println("Input adjacency matrix of graph:");
			else // option 2 (determinant)
				System.out.println("Input the NxN matrix:");
			System.out.println("[separate each entry with a space and press enter after each row]");
			long[][] matrix = inputMatrix(scan, size);
			
			// Perform necessary calculation and print out result
			if(spanningTrees) // Finds determinant of Laplacian matrix
				System.out.println("Number of spanning trees: " + 
						Determinant.numSpanningTrees(Determinant.createLaplacian(matrix)));
			else // Finds determinant of input matrix
				System.out.println("Determinant = " + 
						Determinant.determinant(matrix));
			
			// Keep calculating?
			System.out.println("Calculate again? (y/n)");
			if(scan.next().equals("n"))
				repeat = false;
		}
	}

	public static long[][] inputMatrix(Scanner scan, int size) {
		long[][] matrix = new long[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) { // take user input for each row
				matrix[i][j] = scan.nextLong(); // placing each entry in its respective position
			}
		}
		return matrix;
	}
}

