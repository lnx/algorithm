package solutions;

import java.util.ArrayList;

public class MaximumSubarray {

	int maxSubArray(ArrayList<Integer> nums) {
		int size = nums.size();
		if (size == 0) {
			return Integer.MIN_VALUE;
		}
		int max = nums.get(0);
		for (int i = 1, sum = nums.get(0); i < size; ++i) {
			sum = Math.max(sum + nums.get(i), nums.get(i));
			max = Math.max(max, sum);
		}
		return max;
	}

}
