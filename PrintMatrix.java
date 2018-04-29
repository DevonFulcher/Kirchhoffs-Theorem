
public class PrintMatrix {
	public static void print(long[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.print("|");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
	}
}
