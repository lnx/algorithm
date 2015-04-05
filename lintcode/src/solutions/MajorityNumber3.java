package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityNumber3 {

	int majorityNumber(ArrayList<Integer> nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				if (map.size() == k - 1) {
					Iterator<Integer> it = map.keySet().iterator();
					while (it.hasNext()) {
						int key = it.next();
						if (map.get(key) > 1) {
							map.put(key, map.get(key) - 1);
						} else {
							it.remove();
						}
					}
				} else {
					map.put(i, 1);
				}
			}
		}
		for (int i : map.keySet()) {
			map.put(i, 0);
		}
		int ret = 0, max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				if (map.get(i) > max) {
					max = map.get(i);
					ret = i;
				}
			}
		}
		return ret;
	}

}
