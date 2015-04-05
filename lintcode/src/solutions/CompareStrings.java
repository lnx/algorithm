package solutions;

import java.util.HashMap;
import java.util.Map;

public class CompareStrings {

	boolean compareStrings(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		for (char c : s2.toCharArray()) {
			if (!map.containsKey(c) || map.get(c) <= 0) {
				return false;
			}
			map.put(c, map.get(c) - 1);
		}
		return true;
	}

}
