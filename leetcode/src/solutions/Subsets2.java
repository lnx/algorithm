package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets2 {

	List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(num);
		for (int k = 0; k <= num.length; ++k) {
			subsetsWithDup(num, k, 0, new Stack<Integer>(), ret);
		}
		return ret;
	}

	void subsetsWithDup(int[] num, int k, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (stack.size() == k) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i < num.length; ++i) {
				if (i == start || num[i] != num[i - 1]) {
					stack.push(num[i]);
					subsetsWithDup(num, k, i + 1, stack, ret);
					stack.pop();
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] s = { 1, 1, 2 };
		List<List<Integer>> ret = new Subsets2().subsetsWithDup(s);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
