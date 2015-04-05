package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}
		return sb.toString().matches("0+") ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0 };
		System.out.println(new LargestNumber().largestNumber(nums));
	}

}
