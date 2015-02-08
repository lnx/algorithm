package solutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; ++i) {
			if (map.containsKey(numbers[i])) {
				ret[0] = map.get(numbers[i]) + 1;
				ret[1] = i + 1;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		int[] ret = ts.twoSum(numbers, target);
		System.out.println(ret[0] + " " + ret[1]);
	}

}
