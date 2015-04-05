package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordLadder2 {

	List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Map<String, Set<String>> path = new HashMap<>();
		Set<String> curr = new HashSet<>();
		Set<String> next = new HashSet<>();
		curr.add(start);
		dict.add(end);
		while (!curr.isEmpty() && !curr.contains(end)) {
			dict.removeAll(curr);
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
		List<List<String>> ret = new ArrayList<>();
		if (path.containsKey(end)) {
			Stack<String> stack = new Stack<>();
			stack.push(end);
			genPath(start, path, stack, ret);
		}
		return ret;
	}

	void genPath(String target, Map<String, Set<String>> path, Stack<String> stack, List<List<String>> ret) {
		String top = stack.peek();
		if (top.equals(target)) {
			List<String> list = new ArrayList<>(stack);
			Collections.reverse(list);
			ret.add(list);
		} else {
			for (String pre : path.get(top)) {
				stack.push(pre);
				genPath(target, path, stack, ret);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		String start = "hot";
		String end = "dog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		System.out.println(new WordLadder2().findLadders(start, end, dict));
	}

}
