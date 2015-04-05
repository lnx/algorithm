package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubarraySumClosest {

	ArrayList<Integer> subarraySumClosest(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		Map<Long, Integer> map = new TreeMap<>();
		map.put(0L, -1);
		long sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				ret.add((map.get(sum) + 1));
				ret.add(i);
				return ret;
			}
			map.put(sum, i);
		}
		int start = -1, end = -1;
		long min = Long.MAX_VALUE;
		List<Long> list = new ArrayList<>(map.keySet());
		for (int i = 1; i < list.size(); ++i) {
			long n1 = list.get(i - 1), n2 = list.get(i);
			long abs = Math.abs(n1 - n2);
			if (abs < min) {
				start = Math.min(map.get(n1), map.get(n2)) + 1;
				end = Math.max(map.get(n1), map.get(n2));
				min = abs;
			}
		}
		ret.add(start);
		ret.add(end);
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 2147483647 };
		System.out.println(new SubarraySumClosest().subarraySumClosest(nums));
	}

}
