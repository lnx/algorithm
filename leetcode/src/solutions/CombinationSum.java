package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

	List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void combinationSum(int[] candidates, int target, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i < candidates.length; ++i) {
				if (i == start || candidates[i] != candidates[i - 1]) {
					if (candidates[i] <= target) {
						stack.push(candidates[i]);
						combinationSum(candidates, target - candidates[i], i, stack, ret);
						stack.pop();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 8, 7, 4, 3 };
		int target = 11;
		List<List<Integer>> ansList = new CombinationSum().combinationSum(candidates, target);
		for (List<Integer> ans : ansList) {
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
