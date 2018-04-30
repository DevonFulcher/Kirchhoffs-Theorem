/*
 * This class contains methods to find Laplacian matrix, determinant, number of spanning trees and
 * and number of spanning aborescences.
 * 
 * @author Devon Fulcher, Colin Scruggs
 */

public class Determinant {
	private static long determinantOrSpanningTrees(long[][] matrix, boolean calculateDeterminant) {
		int iStop, jStop, kStop;
		if (calculateDeterminant) {
			iStop = jStop = kStop = 0;
		} else {
			iStop = jStop = kStop = 1;
		}
		long determinant = 1;

		//Each time a j row is multiplied by a scalar the determinant must be divided by that scalar.
		long divisor = 1;

		for(int i = matrix.length - 1; i > iStop; i--) {
			for(int j = i - 1; j >= jStop; j--) {
				long jScalar = matrix[i][i]; //scalar for row j
				long iScalar = matrix[j][i]; //scalar for row i
				if (iScalar != 0) {
					if (jScalar == 0) {
						long[] temp = matrix[i].clone();
						matrix[i] = matrix[j].clone(); 
						matrix[j] = temp.clone();
						determinant *= -1;
					} else {
						divisor *= jScalar;
						for(int k = i; k >= kStop; k--) {
							matrix[j][k] =  -iScalar * matrix[i][k] + jScalar * matrix[j][k];
						}
					}
				}
			}
			determinant *= matrix[i][i];
		}

		//assert: The determinant of any matrix is an integer. The number of spanning trees of a graph is a nonnegative integer.
		return (calculateDeterminant)? determinant * matrix[0][0] / divisor: determinant * matrix[1][1]/ divisor;
	}
	
	
	/* Processes an NxN adjacency matrix A, created from an undirected graph, to produce its
	 * Laplacian matrix. This is done by calculating the graph's degree matrix and subtracting the
	 * input adjacency matrix. 
	 * @author Colin Scruggs
	 * @param NxN 2d array (adjacency matrix) that is at least size 1x1
	 * @return Laplacian matrix minus A
	 */
	public static long[][] createLaplacian(long[][] A) {
		long length = A.length; // stores length of NxN matrix for traversal
		
		// nested for loop to traverse through entire matrix
		for(int i = 0; i < length; i++) {
			// counts number of adjacent connections per node to produce each node's degree
			int count = 0; 
			for(int j = 0; j < length; j++) {
				if(A[i][j] == 1) {
					count++; 
					A[i][j] = -1; // 'subtract' each value in the adjacency matrix
				}
			}
			A[i][i] = count; // set the diagonal of each similar row/column pair to its degree
		}
		// return the modified array A, which is now equal to its Laplacian matrix
		return A; 
		
	}
	
	/* Calculates the determinant of a matrix as represented by a 2d array by using elementary row operations
	 * to reduce the matrix to lower triangular if a column of zeros does not exist. During this construction the determinant is calculated by multiplying the
	 * entries along the diagonal going from bottom right to top left.
	 * 
	 * @author Devon Fulcher
	 * @param NxN 2d array that is at least size 1x1
	 * @return the determinant of this 2d-array/matrix
	 */
	public static long determinant(long[][] matrix) {
		return determinantOrSpanningTrees(matrix, true);
	}
	
	/* Uses Kirchhoff's theorem to calculate the number of spanning trees of a graph as represented by a Laplacian matrix.
	 * It does so by calculating the determinant of the (1,1)-minor of the Laplacian (the Laplacian with just the first row and
	 * column deleted). Calculates the determinant by using elementary row operations to reduce the matrix to lower triangular 
	 * if a column of zeros does not exist. During this construction the determinant is calculated by multiplying the
	 * entries along the diagonal going from bottom right to top left.
	 * 
	 * @author Devon Fulcher
	 * @param NxN 2d array that is a Laplacian matrix and at least size 2x2
	 * @return the number of distinct spanning trees that this Laplacian matrix's graph contains where vertices are distinguishable
	 */
	public static long numSpanningTrees(long[][] matrix) {
		return determinantOrSpanningTrees(matrix, false);
	}
	
	/* Uses Tutte's theorem to calculate the number of distinct spanning aborescences of a digraph as represented by a special matrix that is 
	 * defined in the parameters of the javadocs. It does so by calculating the determinant of the (1,1)-minor of this special matrix (this
	 * special matrix with just the first row and column deleted). Calculates the determinant by using elementary row operations to reduce the matrix to lower triangular 
	 * if a column of zeros does not exist. During this construction the determinant is calculated by multiplying the
	 * entries along the diagonal going from bottom right to top left.
	 * 
	 * @author Devon Fulcher
	 * @param NxN 2d array with size at least 2x2 such that for all i & j
	 * 		if (i == j) {
	 * 			matrix[i][j] = in-degree of vertex j
	 *		} else if (i != j and vertex i and vertex j are connected by an edge) {
	 *			matrix[i][j] = -1
	 *		} else {
	 *			matrix[i][j] = 0
	 *		}
	 * @return the number of distinct spanning arborescences that this matrix's graph contains where vertices are distinguishable
	 */
	public static long numSpanningAborescences(long[][] matrix) {
		return determinantOrSpanningTrees(matrix, false);
	}
}