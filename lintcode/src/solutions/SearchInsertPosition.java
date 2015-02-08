package solutions;

import java.util.ArrayList;

public class SearchInsertPosition {

	int searchInsert(ArrayList<Integer> a, int target) {
		int i = 0;
		while (i < a.size() && target > a.get(i)) {
			++i;
		}
		return i;
	}

}
