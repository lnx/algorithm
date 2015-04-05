package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i])) {
				ret[0] = map.get(nums[i]) + 1;
				ret[1] = i + 1;
				break;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
	}

}
