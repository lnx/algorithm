package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	String largestNumber(int[] num) {
		StringBuilder sb = new StringBuilder();
		if (num.length > 0) {
			String[] strs = new String[num.length];
			for (int i = 0; i < num.length; ++i) {
				strs[i] = String.valueOf(num[i]);
			}
			Arrays.sort(strs, new Comparator<String>() {
				public int compare(String s1, String s2) {
					return (s2 + s1).compareTo(s1 + s2);
				}
			});
			for (String s : strs) {
				sb.append(s);
			}
		}
		return sb.toString().matches("0+") ? "0" : sb.toString();
	}

}
