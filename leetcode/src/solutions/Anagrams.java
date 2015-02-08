package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	List<String> anagrams(String[] strs) {
		List<String> ret = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			if (word != null) {
				String key = sort(word);
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<String>());
				}
				map.get(key).add(word);
			}
		}
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				ret.addAll(list);
			}
		}
		return ret;
	}

	String sort(String word) {
		char[] chs = word.toCharArray();
		Arrays.sort(chs);
		return String.valueOf(chs);
	}

}
