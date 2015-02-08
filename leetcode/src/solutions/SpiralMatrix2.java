package solutions;

public class SpiralMatrix2 {

	int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int top = 0, bottom = n - 1, left = 0, right = n - 1, k = 0;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right && top <= bottom; ++i) {
				ret[top][i] = ++k;
			}
			++top;
			for (int i = top; i <= bottom && left <= right; ++i) {
				ret[i][right] = ++k;
			}
			--right;
			for (int i = right; i >= left && top <= bottom; --i) {
				ret[bottom][i] = ++k;
			}
			--bottom;
			for (int i = bottom; i >= top && left <= right; --i) {
				ret[i][left] = ++k;
			}
			++left;
		}
		return ret;
	}

}
