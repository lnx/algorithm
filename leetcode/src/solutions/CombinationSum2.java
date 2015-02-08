package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum2 {

	List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum2(candidates, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void combinationSum2(int[] candidates, int target, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i < candidates.length; ++i) {
				if (i == start || candidates[i] != candidates[i - 1]) {
					if (candidates[i] <= target) {
						stack.push(candidates[i]);
						combinationSum2(candidates, target - candidates[i], i + 1, stack, ret);
						stack.pop();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> ansList = new CombinationSum2().combinationSum2(candidates, target);
		for (List<Integer> ans : ansList) {
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
