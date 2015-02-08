package solutions;

import java.util.ArrayList;
import java.util.Collections;

public class UniquePermutations {

	ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (nums != null) {
			Collections.sort(nums);
			search(nums, 0, ret);
		}
		return ret;
	}

	void search(ArrayList<Integer> nums, int k, ArrayList<ArrayList<Integer>> ret) {
		if (k == nums.size()) {
			ret.add(new ArrayList<Integer>(nums));
		} else {
			for (int i = k; i < nums.size(); ++i) {
				boolean dup = false;
				for (int j = k; j < i; ++j) {
					if (nums.get(j) == nums.get(i)) {
						dup = true;
						break;
					}
				}
				if (!dup) {
					swap(nums, k, i);
					search(nums, k + 1, ret);
					swap(nums, k, i);
				}
			}
		}
	}

	void swap(ArrayList<Integer> nums, int i, int j) {
		int t = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, t);
	}

}
