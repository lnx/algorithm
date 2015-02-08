package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets {

	List<List<Integer>> subsets(int[] s) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(s);
		for (int k = 0; k <= s.length; ++k) {
			subsets(s, k, 0, new Stack<Integer>(), ret);
		}
		return ret;
	}

	void subsets(int[] s, int k, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (stack.size() == k) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i < s.length; ++i) {
				stack.push(s[i]);
				subsets(s, k, i + 1, stack, ret);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		int[] s = { 1, 2, 2 };
		List<List<Integer>> ret = new Subsets().subsets(s);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
