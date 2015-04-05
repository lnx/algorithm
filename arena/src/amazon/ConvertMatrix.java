package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix {

	static int[] convertMatrix(int width, int height, int[] matrix) {
		List<Integer> list = new ArrayList<>();
		boolean[] visit = new boolean[matrix.length];
		int i = 0, j = -1;
		while (true) {
			boolean move = false;
			// right
			while (check(width, height, matrix, visit, i, j + 1)) {
				int index = getIndex(width, i, ++j);
				visit[index] = true;
				list.add(matrix[index]);
				move = true;
			}
			// down-left
			while (check(width, height, matrix, visit, i + 1, j - 1)) {
				int index = getIndex(width, ++i, --j);
				visit[index] = true;
				list.add(matrix[index]);
				move = true;
			}
			// left
			while (check(width, height, matrix, visit, i, j - 1)) {
				int index = getIndex(width, i, --j);
				visit[index] = true;
				list.add(matrix[index]);
				move = true;
			}
			// up
			while (check(width, height, matrix, visit, i - 1, j)) {
				int index = getIndex(width, --i, j);
				visit[index] = true;
				list.add(matrix[index]);
				move = true;
			}
			if (!move) {
				break;
			}
		}
		return listToArray(list);
	}

	static boolean check(int width, int height, int[] matrix, boolean[] visit, int x, int y) {
		return y >= 0 && y < width && x >= 0 && x < height && !visit[getIndex(width, x, y)];
	}

	static int getIndex(int width, int x, int y) {
		return x * width + y;
	}

	static int[] listToArray(List<Integer> list) {
		int[] a = new int[list.size()];
		for (int i = 0; i < a.length; ++i) {
			a[i] = list.get(i);
		}
		return a;
	}

	public static void main(String[] args) {
		int w1 = 5;
		int h1 = 3;
		int[] m1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println(Arrays.toString(convertMatrix(w1, h1, m1)));

		int w2 = 3;
		int h2 = 5;
		int[] m2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println(Arrays.toString(convertMatrix(w2, h2, m2)));
	}

}
