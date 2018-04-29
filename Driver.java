import java.util.*;
import java.lang.*;

public class Driver {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (true) {
		System.out.println("How many vertices are in the graph?");
		int size = scan.nextInt();
		System.out.println("Input adjacency matrix of graph. Press enter after each row");
		long[][] matrix = new long[size][size];
		for (int i = 0; i < size; i++) {
			String input = scan.next();
			for (int j = 0; j < size; j++) {
				matrix[i][j] = (input.charAt(j) == '1')? 1 : 0;
			}
		}
		System.out.println("Number of spanning trees: " + 
		Determinant.numSpanningTrees(Determinant.createLaplacian(matrix)));
		System.out.println("again?");
		}
	}
}

