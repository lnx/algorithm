package solutions;

import java.util.Arrays;

public class ThreeSumCloset {

	int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int ret = nums[0] + nums[1] + nums[2];
		for (int k = 0; k < nums.length - 2; ++k) {
			for (int i = k + 1, j = nums.length - 1; i < j;) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum == target) {
					return target;
				} else {
					if (Math.abs(target - sum) < Math.abs(target - ret)) {
						ret = sum;
					}
					if (sum < target) {
						++i;
					} else {
						--j;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(new ThreeSumCloset().threeSumClosest(nums, target));
	}

}
