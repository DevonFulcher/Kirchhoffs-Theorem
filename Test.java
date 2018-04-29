
public class Test {
	public static void main(String args[]) {
		System.out.println("determinant of matrices:");
		long[][] a = {{2,3,-1},
				{0,5,3},
				{-4,-6,2}}; //determinant = 0
		long[][] b = {{0,2,-4,5},
				{3,0,-3,6},
				{2,4,5,7},
				{5,-1,-3,1}}; //determinant = 585
		long[][] c = {{5,1},
				{9,8}}; //determinant = 31
		long[][] d = {{1,5,0},
				{5,0,0},
				{1,2,3}}; //determinant = -75
		long[][] e = {{0,1,0,0},
				{0,0,0,1},
				{0,0,1,0},
				{1,0,0,0}}; //determinant = 1
		long[][] f = {{0,1,0,0},
				{0,0,0,0},
				{0,0,1,0},
				{1,0,0,0}}; //determinant = 0
		long[][] g = {{0,0},
				{0,0}}; //determinant = 0
		System.out.println(Determinant.determinant(a));
		System.out.println(Determinant.determinant(b));
		System.out.println(Determinant.determinant(c));
		System.out.println(Determinant.determinant(d));
		System.out.println(Determinant.determinant(e));
		System.out.println(Determinant.determinant(f));
		System.out.println(Determinant.determinant(g));

		//---------------------------------------------

		// Simple graph 1
		long[][] adj1 = {{0, 1, 1, 0},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{0, 0, 1, 0}};
		System.out.println("Adjacency matrix 1: ");
		PrintMatrix.print(adj1);
		System.out.println("Q = L - A");
		long[][] q1 = Determinant.createLaplacian(adj1);
		PrintMatrix.print(q1);
		System.out.println("number of spanning trees of adjacency matrix:");
		System.out.println(Determinant.numSpanningTrees(q1));

		// Simple graph 2
		long[][] adj2 = 
				{{0, 1, 1, 0, 0},
				{1, 0, 0, 1, 1},
				{1, 0, 0, 0, 1},
				{0, 1, 0, 0, 0},
				{0, 1, 1, 0, 0}};
		System.out.println("Adjacency matrix 2: ");
		PrintMatrix.print(adj2);
		System.out.println("Q = L - A");
		long[][] q2 = Determinant.createLaplacian(adj2);
		PrintMatrix.print(q2);
		System.out.println("number of spanning trees of adjacency matrix:");
		System.out.println(Determinant.numSpanningTrees(q2));
		
		// Graph w/ one unconnected node
		long[][] adj3 = 
				{{0, 1, 1, 0, 0},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 1, 1, 0, 0}};
		System.out.println("Adjacency matrix 3: ");
		PrintMatrix.print(adj3);
		System.out.println("Q = L - A");
		long[][] q3 = Determinant.createLaplacian(adj3);
		PrintMatrix.print(q3);
		System.out.println("number of spanning trees of adjacency matrix:");
		System.out.println(Determinant.numSpanningTrees(q3));
		
		// Complete graph 
		long[][] adj4 = 
				{{0, 1, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 0, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 1, 0}};
		System.out.println("Adjacency matrix 4: ");
		PrintMatrix.print(adj4);
		System.out.println("Q = L - A");
		long[][] q4 = Determinant.createLaplacian(adj4);
		PrintMatrix.print(q4);
		System.out.println("number of spanning trees of adjacency matrix:");
		System.out.println(Determinant.numSpanningTrees(q4));
	}
}
