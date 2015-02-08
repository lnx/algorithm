package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Subsets {

	ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
		Collections.sort(list);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		search(list, 0, new Stack<Integer>(), ret);
		return ret;
	}

	void search(ArrayList<Integer> list, int k, Stack<Integer> stack, ArrayList<ArrayList<Integer>> ret) {
		ret.add(new ArrayList<Integer>(stack));
		for (int i = k, size = list.size(); i < size; ++i) {
			stack.push(list.get(i));
			search(list, i + 1, stack, ret);
			stack.pop();
		}
	}

}
