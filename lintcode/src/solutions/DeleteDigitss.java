package solutions;

import java.util.ArrayList;
import java.util.List;

public class DeleteDigitss {

	String DeleteDigits(String s, int k) {
		List<Integer> list = new ArrayList<>();
		for (char c : s.toCharArray()) {
			list.add(c - '0');
		}
		for (int i = 0; i < k; ++i) {
			int pos = 0;
			while (pos + 1 < list.size() && list.get(pos) <= list.get(pos + 1)) {
				++pos;
			}
			list.remove(pos);
		}
		while (!list.isEmpty() && list.get(0) == 0) {
			list.remove(0);
		}
		if (list.isEmpty()) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i);
		}
		return sb.toString();
	}

}
