package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	List<String> findRepeatedDnaSequences(String s) {
		List<String> ret = new ArrayList<>();
		int len = s.length();
		if (len > 10) {
			int cur = 0;
			for (int i = 0; i < 10; ++i) {
				cur = (cur << 2) + convert(s.charAt(i));
			}
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(cur, 1);
			for (int i = 10, mask = ~(3 << 18); i < len; ++i) {
				cur = ((cur & mask) << 2) + convert(s.charAt(i));
				map.put(cur, map.getOrDefault(cur, 0) + 1);
				if (map.get(cur) == 2) {
					ret.add(s.substring(i - 9, i + 1));
				}
			}
		}
		return ret;
	}

	int convert(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		String s = "AAAAAAAAAAAA";
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
	}

}
