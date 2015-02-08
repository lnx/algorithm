package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

	static final String NONE = "None";

	String calculateTheRightSequence(int[][] original, int[][] target, char[] operations) {
		List<String> ret = new ArrayList<>();
		search(original, target, operations, 0, ret);
		if (ret.size() > 0) {
			return ret.get(0);
		} else {
			return NONE;
		}
	}

	void search(int[][] original, int[][] target, char[] operations, int k, List<String> ret) {
		if (k == operations.length) {
			if (checkOperations(cloneMatrix(original), target, operations)) {
				ret.add(String.valueOf(operations));
			}
		} else {
			for (int i = k; i < operations.length; ++i) {
				boolean dup = false;
				for (int j = k; j < i; ++j) {
					if (operations[j] == operations[i]) {
						dup = true;
						break;
					}
				}
				if (!dup) {
					swap(operations, k, i);
					search(original, target, operations, k + 1, ret);
					swap(operations, k, i);
				}
			}
		}
	}

	boolean checkOperations(int[][] original, int[][] target, char[] operations) {
		int rows = original.length, cols = rows > 0 ? original[0].length : 0;
		int[] pos = findZero(original, rows, cols);
		if (moveZero(original, rows, cols, pos[0], pos[1], operations)) {
			return isSame(original, target, rows, cols);
		} else {
			return false;
		}
	}

	int[] findZero(int[][] matrix, int rows, int cols) {
		int[] pos = new int[2];
		Arrays.fill(pos, -1);
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (matrix[i][j] == 0) {
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}
		return pos;
	}

	boolean moveZero(int[][] matrix, int rows, int cols, int i, int j, char[] operations) {
		for (char c : operations) {
			switch (c) {
			case 'U':
				if (i - 1 >= 0) {
					swap(matrix, i, j, i - 1, j);
					--i;
				} else {
					return false;
				}
				break;
			case 'R':
				if (j + 1 < cols) {
					swap(matrix, i, j, i, j + 1);
					++j;
				} else {
					return false;
				}
				break;
			case 'D':
				if (i + 1 < rows) {
					swap(matrix, i, j, i + 1, j);
					++i;
				} else {
					return false;
				}
				break;
			case 'L':
				if (j - 1 >= 0) {
					swap(matrix, i, j, i, j - 1);
					--j;
				} else {
					return false;
				}
				break;
			default:
				return false;
			}
		}
		return true;
	}

	boolean isSame(int[][] original, int[][] target, int rows, int cols) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (original[i][j] != target[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	int[][] cloneMatrix(int[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[][] ret = new int[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				ret[i][j] = matrix[i][j];
			}
		}
		return ret;
	}

	void swap(int[][] matrix, int srcX, int srcY, int dstX, int dstY) {
		int t = matrix[srcX][srcY];
		matrix[srcX][srcY] = matrix[dstX][dstY];
		matrix[dstX][dstY] = t;
	}

	void swap(char[] a, int i, int j) {
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		Matrix m = new Matrix();

		int[][] original1 = { { 20, 18, 7, 19, 10 }, { 24, 4, 15, 11, 9 }, { 13, 0, 22, 12, 14 }, { 23, 16, 1, 2, 5 }, { 21, 17, 8, 3, 6 } };
		int[][] target1 = { { 20, 18, 7, 19, 10 }, { 24, 15, 11, 12, 9 }, { 13, 4, 22, 2, 14 }, { 23, 16, 0, 1, 5 }, { 21, 17, 8, 3, 6 } };
		char[] operations1 = "RRLUDD".toCharArray();
		System.out.println(m.calculateTheRightSequence(original1, target1, operations1));

		int[][] original2 = { { 20, 18, 7, 19, 10 }, { 24, 4, 15, 11, 9 }, { 13, 0, 22, 12, 14 }, { 23, 16, 1, 2, 5 }, { 21, 17, 8, 3, 6 } };
		int[][] target2 = { { 20, 18, 7, 19, 10 }, { 24, 4, 0, 11, 9 }, { 13, 22, 15, 12, 14 }, { 23, 16, 1, 2, 5 }, { 21, 17, 8, 3, 6 } };
		char[] operations2 = "UR".toCharArray();
		System.out.println(m.calculateTheRightSequence(original2, target2, operations2));
	}

}
