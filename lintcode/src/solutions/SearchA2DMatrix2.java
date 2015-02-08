package solutions;

import java.util.ArrayList;

public class SearchA2DMatrix2 {

	int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
		int rows = matrix.size(), cols = rows > 0 ? matrix.get(0).size() : 0;
		int dup = 0;
		int i = rows - 1, j = 0;
		while (i >= 0 && j < cols) {
			int cur = matrix.get(i).get(j);
			if (target > cur) {
				++j;
			} else {
				--i;
				if (target == cur) {
					++dup;
				}
			}
		}
		return dup;
	}

}
