package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null) {
			return 0;
		}
		if (start.equals(end)) {
			return 1;
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		dict.remove(start);
		int k = 1;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				String word = queue.poll();
				for (int j = 0, len = word.length(); j < len; ++j) {
					for (char c = 'a'; c <= 'z'; ++c) {
						if (c != word.charAt(j)) {
							StringBuilder sb = new StringBuilder(word);
							sb.setCharAt(j, c);
							String change = sb.toString();
							if (change.equals(end)) {
								return k + 1;
							}
							if (dict.contains(change)) {
								queue.offer(change);
								dict.remove(change);
							}
						}
					}
				}
			}
			++k;
		}
		return 0;
	}

	public static void main(String[] args) {
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}

}
