package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

	List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		search(n, k, 1, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int n, int k, int start, Stack<Integer> stack, List<List<Integer>> ret) {
		if (stack.size() == k) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = start; i <= n; ++i) {
				stack.push(i);
				search(n, k, i + 1, stack, ret);
				stack.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
	}

}
