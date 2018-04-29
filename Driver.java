import java.util.*;
import java.lang.*;

public class Driver {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (true) {
		System.out.println("How many vertices are in the graph?");
		int size = scan.nextInt();
		System.out.println("Input adjacency matrix of graph. Press enter after each row");
		long[][] matrix = new long[size][size];
		for (int i = 0; i < size; i++) {
			long input = scan.nextLong();
			for (int j = 0; j < size; j++) {
				long truncate = (long) Math.pow(10, input);
				matrix[i][j] = input / truncate;
				System.out.println("asdf" +input / truncate);
				input = input - truncate;

//				long digit = input - (((long)((int)(input/10)))*10);
//				System.out.println("here: " + (((long)((int)(input/10)))*10));
//				System.out.println(digit);
//				matrix[i][j] = digit;				
//				input /= 10;
			}
		}
		System.out.println("Number of spanning trees: " + 
		Determinant.numSpanningTrees(Determinant.createLaplacian(matrix)));
		System.out.println("again?");
		}
	}
}

