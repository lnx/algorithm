package solutions;

public class SearchA2DMatrix {

	boolean searchMatrix(int[][] matrix, int target) {
		int low = -1, high = matrix.length;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (target < matrix[mid][0]) {
				high = mid;
			} else {
				low = mid;
			}
		}
		if (low >= 0) {
			int left = -1, right = matrix[low].length;
			while (left + 1 < right) {
				int mid = left + (right - left) / 2;
				if (target > matrix[low][mid]) {
					left = mid;
				} else {
					right = mid;
				}
			}
			return right < matrix[low].length && matrix[low][right] == target;
		} else {
			return false;
		}
	}

}
