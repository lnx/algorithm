package solutions;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	String minWindow(String s, String t) {
		String ret = "";
		int slen = s.length(), tlen = t.length();
		Map<Character, Integer> dict = new HashMap<>();
		for (char c : t.toCharArray()) {
			dict.put(c, dict.containsKey(c) ? dict.get(c) + 1 : 1);
		}
		Map<Character, Integer> window = new HashMap<>();
		for (int front = 0, rear = 0, count = 0; rear < slen;) {
			char r = s.charAt(rear++);
			window.put(r, window.containsKey(r) ? window.get(r) + 1 : 1);
			if (dict.containsKey(r) && window.get(r) <= dict.get(r)) {
				++count;
			}
			while (count == tlen) {
				if (ret.equals("") || rear - front < ret.length()) {
					ret = s.substring(front, rear);
				}
				char f = s.charAt(front++);
				window.put(f, window.get(f) - 1);
				if (dict.containsKey(f) && window.get(f) < dict.get(f)) {
					--count;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}

}
