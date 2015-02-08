package solutions;

import java.util.ArrayList;

public class SearchA2DMatrix {

	boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
		int m = matrix.size(), n = m > 0 ? matrix.get(0).size() : 0;
		int low = -1, high = m * n;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (target > matrix.get(mid / n).get(mid % n)) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high < m * n && matrix.get(high / n).get(high % n) == target ? true : false;
	}

}
