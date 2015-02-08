package solutions;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {

	void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		int len = 0;
		for (int i = 0, size = nums.size(); i + 1 < size; ++i) {
			if (nums.get(i) > nums.get(i + 1)) {
				len = i + 1;
				break;
			}
		}
		if (len > 0) {
			reverse(nums, 0, len);
			reverse(nums, len, nums.size() - len);
			reverse(nums, 0, nums.size());
		}
	}

	void reverse(ArrayList<Integer> nums, int offset, int len) {
		for (int i = offset, j = offset + len - 1; i < j; ++i, --j) {
			int t = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, t);
		}
	}

}
