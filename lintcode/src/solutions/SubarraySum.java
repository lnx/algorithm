package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

	ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			long sum = 0;
			for (int j = i; j < nums.length; ++j) {
				sum += nums[j];
				if (sum == 0) {
					ret.add(i);
					ret.add(j);
					return ret;
				}
			}
		}
		return ret;
	}

	ArrayList<Integer> subarraySum1(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		Map<Long, Integer> map = new HashMap<>();
		map.put(0L, -1);
		long sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				ret.add(map.get(sum) + 1);
				ret.add(i);
				return ret;
			}
			map.put(sum, i);
		}
		return ret;
	}

}
