package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarrayDifference {

	int maxDiffSubArrays(ArrayList<Integer> nums) {
		int size = nums.size();
		if (size <= 1) {
			return 0;
		}
		int[] maxLeft = new int[size];
		maxLeft[0] = nums.get(0);
		for (int i = 1, sum = nums.get(0); i < size; ++i) {
			sum = Math.max(sum + nums.get(i), nums.get(i));
			maxLeft[i] = Math.max(maxLeft[i - 1], sum);
		}
		int[] minLeft = new int[size];
		minLeft[0] = nums.get(0);
		for (int i = 1, sum = nums.get(0); i < size; ++i) {
			sum = Math.min(sum + nums.get(i), nums.get(i));
			minLeft[i] = Math.min(minLeft[i - 1], sum);
		}
		int[] maxRight = new int[size];
		maxRight[size - 1] = nums.get(size - 1);
		for (int i = size - 2, sum = nums.get(size - 1); i >= 0; --i) {
			sum = Math.max(sum + nums.get(i), nums.get(i));
			maxRight[i] = Math.max(maxRight[i + 1], sum);
		}
		int[] minRight = new int[size];
		minRight[size - 1] = nums.get(size - 1);
		for (int i = size - 2, sum = nums.get(size - 1); i >= 0; --i) {
			sum = Math.min(sum + nums.get(i), nums.get(i));
			minRight[i] = Math.min(minRight[i + 1], sum);
		}
		int diff = 0;
		for (int i = 0; i < size - 1; ++i) {
			diff = Math.max(diff, Math.max(Math.abs(maxLeft[i] - minRight[i + 1]), Math.abs(minLeft[i] - maxRight[i + 1])));
		}
		return diff;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1, 2, -3, 1};
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a));
		System.out.println(new MaximumSubarrayDifference().maxDiffSubArrays(nums));
	}

}
