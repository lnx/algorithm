package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermuation {

	ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		int i = nums.size() - 1;
		while (i > 0 && nums.get(i - 1) >= nums.get(i)) {
			--i;
		}
		if (i > 0) {
			int j = nums.size() - 1;
			while (nums.get(i - 1) >= nums.get(j)) {
				--j;
			}
			swap(nums, i - 1, j);
		}
		reverse(nums, i, nums.size() - 1);
		return nums;
	}

	void swap(ArrayList<Integer> nums, int i, int j) {
		int t = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, t);
	}

	void reverse(ArrayList<Integer> nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 1 };
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a));
		System.out.println(new NextPermuation().nextPermuation(nums));
	}

}
