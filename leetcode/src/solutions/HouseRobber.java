package solutions;

public class HouseRobber {

	int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int max = Math.max(nums[0], nums[1]);
		int a0 = nums[0], a1 = max;
		for (int i = 2; i < nums.length; ++i) {
			int a2 = Math.max(a0 + nums[i], a1);
			a0 = a1;
			a1 = a2;
			max = Math.max(max, a2);
		}
		return max;
	}

}
