package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	List<String> anagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] chs = s.toCharArray();
			Arrays.sort(chs);
			String sorted = Arrays.toString(chs);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<String>());
			}
			map.get(sorted).add(s);
		}
		List<String> ret = new ArrayList<>();
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				ret.addAll(list);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		String[] strs = { "lint", "intl", "inlt", "code" };
		System.out.println(new Anagrams().anagrams(strs));
	}

}
