package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ThreeSum {

	ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		search(nums, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int[] nums, int k, Stack<Integer> stack, ArrayList<ArrayList<Integer>> ret) {
		if (stack.size() == 3) {
			if (stack.get(0) + stack.get(1) + stack.get(2) == 0) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(stack.get(0));
				list.add(stack.get(1));
				list.add(stack.get(2));
				ret.add(list);
			}
		} else {
			for (int i = k; i < nums.length; ++i) {
				if (i == k || nums[i] != nums[i - 1]) {
					stack.push(nums[i]);
					search(nums, i + 1, stack, ret);
					stack.pop();
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(new ThreeSum().threeSum(nums));
	}

}
