package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	int longestConsecutive(int[] num) {
		int ret = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : num) {
			map.put(i, 0);
		}
		for (int i : num) {
			if (map.get(i) == 0) {
				int len = 1;
				for (int j = i + 1; map.containsKey(j); ++j) {
					map.put(j, 1);
					++len;
				}
				for (int j = i - 1; map.containsKey(j); --j) {
					map.put(j, 1);
					++len;
				}
				ret = Math.max(ret, len);
			}
		}
		return ret;
	}

}
