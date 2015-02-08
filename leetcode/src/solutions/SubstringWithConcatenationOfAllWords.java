package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	List<Integer> findSubstring(String s, String[] l) {
		List<Integer> ret = new ArrayList<>();
		int slen = s.length(), llen = l.length, wlen = l[0].length();
		Map<String, Integer> dict = new HashMap<>();
		for (String word : l) {
			dict.put(word, dict.containsKey(word) ? dict.get(word) + 1 : 1);
		}
		Map<String, Integer> window = new HashMap<>();
		for (int i = 0; i < wlen; ++i) {
			window.clear();
			for (int front = i, rear = i, count = 0; rear <= slen - wlen;) {
				String word = s.substring(rear, rear + wlen);
				rear += wlen;
				if (dict.containsKey(word)) {
					window.put(word, window.containsKey(word) ? window.get(word) + 1 : 1);
					++count;
					while (window.get(word) > dict.get(word)) {
						String remove = s.substring(front, front + wlen);
						front += wlen;
						window.put(remove, window.get(remove) - 1);
						--count;
					}
					if (count == llen) {
						ret.add(front);
					}
				} else {
					front = rear;
					window.clear();
					count = 0;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		String s = "foobarfoo";
		String[] l = { "foo", "bar" };
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, l));
	}

}
