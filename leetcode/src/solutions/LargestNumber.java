package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	String largestNumber(int[] nums) {
		StringBuilder sb = new StringBuilder();
		if (nums.length > 0) {
			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; ++i) {
				strs[i] = String.valueOf(nums[i]);
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

	public static void main(String[] args) {
		int[] nums = { 100, 1 };
		System.out.println(new LargestNumber().largestNumber(nums));
	}

}
