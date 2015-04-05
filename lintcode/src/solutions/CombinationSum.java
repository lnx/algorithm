package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

	List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(candidates);
		search(candidates, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int[] candidates, int target, int k, Stack<Integer> stack, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = k; i < candidates.length; ++i) {
				if (target >= candidates[i]) {
					stack.push(candidates[i]);
					search(candidates, target - candidates[i], i, stack, ret);
					stack.pop();
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 1, 2 };
		int target = 2;
		System.out.println(new CombinationSum().combinationSum(candidates, target));
	}

}
