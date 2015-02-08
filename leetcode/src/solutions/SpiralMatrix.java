package solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		int top = 0, bottom = matrix.length - 1, left = 0, right = (matrix.length > 0 ? matrix[0].length : 0) - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right && top <= bottom; ++i) {
				ret.add(matrix[top][i]);
			}
			++top;
			for (int i = top; i <= bottom && left <= right; ++i) {
				ret.add(matrix[i][right]);
			}
			--right;
			for (int i = right; i >= left && top <= bottom; --i) {
				ret.add(matrix[bottom][i]);
			}
			--bottom;
			for (int i = bottom; i >= top && left <= right; --i) {
				ret.add(matrix[i][left]);
			}
			++left;
		}
		return ret;
	}

}
