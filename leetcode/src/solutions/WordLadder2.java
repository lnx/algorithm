package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordLadder2 {

	List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> ret = new ArrayList<>();
		Map<String, Set<String>> path = new HashMap<>();
		Set<String> curr = new HashSet<>();
		Set<String> next = new HashSet<>();
		curr.add(start);
		dict.add(end);
		while (!curr.isEmpty()) {
			if (curr.contains(end)) {
				Stack<String> stack = new Stack<>();
				stack.push(end);
				buildPath(path, start, stack, ret);
				return ret;
			}
			for (String word : curr) {
				dict.remove(word);
			}
			for (String word : curr) {
				for (int i = 0, len = word.length(); i < len; ++i) {
					for (char c = 'a'; c <= 'z'; ++c) {
						if (c != word.charAt(i)) {
							String neighbor = word.substring(0, i) + c + word.substring(i + 1);
							if (dict.contains(neighbor)) {
								next.add(neighbor);
								if (!path.containsKey(neighbor)) {
									path.put(neighbor, new HashSet<String>());
								}
								path.get(neighbor).add(word);
							}
						}
					}
				}
			}
			curr.clear();
			curr.addAll(next);
			next.clear();
		}
		return ret;
	}

	void buildPath(Map<String, Set<String>> path, String start, Stack<String> stack, List<List<String>> ret) {
		String top = stack.peek();
		if (top.equals(start)) {
			List<String> list = new ArrayList<>();
			for (int i = stack.size() - 1; i >= 0; --i) {
				list.add(stack.get(i));
			}
			ret.add(list);
		} else {
			for (String pre : path.get(top)) {
				stack.push(pre);
				buildPath(path, start, stack, ret);
				stack.pop();
			}
		}
	}

}
