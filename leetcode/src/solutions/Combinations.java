package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

	List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		dfs(n, k, 1, new Stack<Integer>(), ret);
		return ret;
	}

	void dfs(int n, int k, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (stack.size() == k) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i <= n; ++i) {
				stack.push(i);
				dfs(n, k, i + 1, stack, ret);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> ret = new Combinations().combine(5, 2);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
