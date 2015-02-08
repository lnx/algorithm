package solutions;

import java.util.ArrayList;

public class SearchForARange {

	ArrayList<Integer> searchRange(ArrayList<Integer> a, int target) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(searchLeft(a, target));
		ret.add(searchRight(a, target));
		return ret;
	}

	int searchLeft(ArrayList<Integer> a, int target) {
		int low = -1, high = a.size();
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (target > a.get(mid)) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high < a.size() && a.get(high) == target ? high : -1;
	}

	int searchRight(ArrayList<Integer> a, int target) {
		int low = -1, high = a.size();
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (target < a.get(mid)) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low > -1 && a.get(low) == target ? low : -1;
	}

}
