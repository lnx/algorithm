package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KSum2 {

	ArrayList<ArrayList<Integer>> kSumII(int nums[], int k, int target) {
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		search(nums, k, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int[] nums, int k, int target, int pos, Stack<Integer> stack, ArrayList<ArrayList<Integer>> ret) {
		if (k == 0) {
			if (target == 0) {
				ret.add(new ArrayList<>(stack));
			}
		} else {
			for (int i = pos; i < nums.length; ++i) {
				if (i == pos || nums[i] != nums[i - 1]) {
					stack.push(nums[i]);
					search(nums, k - 1, target - nums[i], i + 1, stack, ret);
					stack.pop();
				}
			}
		}
	}

}
