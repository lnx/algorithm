package solutions;

public class RotateArray {

	void rotate(int[] nums, int k) {
		if (nums.length > 1 && k > 0) {
			k %= nums.length;
			reverse(nums, 0, nums.length - k - 1);
			reverse(nums, nums.length - k, nums.length - 1);
			reverse(nums, 0, nums.length - 1);
		}
	}

	void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; ++i, --j) {
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
		}
	}

}
