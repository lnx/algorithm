package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		dict.remove(start);
		dict.add(end);
		for (int level = 0; !queue.isEmpty();) {
			++level;
			for (int i = 0, size = queue.size(); i < size; ++i) {
				String word = queue.poll();
				if (word.equals(end)) {
					return level;
				} else {
					for (int j = 0, len = word.length(); j < len; ++j) {
						for (char c = 'a'; c <= 'z'; ++c) {
							String next = word.substring(0, j) + c + word.substring(j + 1);
							if (dict.contains(next)) {
								queue.offer(next);
								dict.remove(next);
							}
						}
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String start = "a";
		String end = "a";
		Set<String> dict = new HashSet<>();
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}

}
