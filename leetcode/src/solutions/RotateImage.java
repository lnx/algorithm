package solutions;

public class RotateImage {

	void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0, half = len / 2; i <= half; ++i) {
			for (int j = i, end = len - i - 1; j < end; ++j) {
				int v = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = v;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new RotateImage().rotate(matrix);
		for (int i = 0, len = matrix.length; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
