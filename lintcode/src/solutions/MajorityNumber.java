package solutions;

import java.util.ArrayList;

public class MajorityNumber {

	int majorityNumber(ArrayList<Integer> nums) {
		int n = 0, count = 0;
		for (int i : nums) {
			if (count == 0) {
				++count;
				n = i;
			} else {
				if (i == n) {
					++count;
				} else {
					--count;
				}
			}
		}
		return n;
	}

}
