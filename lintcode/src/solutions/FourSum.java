package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FourSum {
	
	ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		search(nums, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int[] nums, int target, int k, Stack<Integer> stack, ArrayList<ArrayList<Integer>> ret) {
		if (stack.size() == 4) {
			if (stack.get(0) + stack.get(1) + stack.get(2) + stack.get(3) == target) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(stack.get(0));
				list.add(stack.get(1));
				list.add(stack.get(2));
				list.add(stack.get(3));
				ret.add(list);
			}
		} else {
			for (int i = k; i < nums.length; ++i) {
				if (i == k || nums[i] != nums[i - 1]) {
					stack.push(nums[i]);
					search(nums, target, i + 1, stack, ret);
					stack.pop();
				}
			}
		}
	}

}
