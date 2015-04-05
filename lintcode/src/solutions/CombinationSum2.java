package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum2 {

	List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<>();
		search(num, target, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int[] num, int target, int pos, Stack<Integer> stack, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<Integer>(stack));
		} else {
			for (int i = pos; i < num.length; ++i) {
				if (target >= num[i] && (i == pos || num[i] != num[i - 1])) {
					stack.push(num[i]);
					search(num, target - num[i], i + 1, stack, ret);
					stack.pop();
				}
			}
		}
	}

}
