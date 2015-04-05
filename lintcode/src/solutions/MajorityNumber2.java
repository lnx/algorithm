package solutions;

import java.util.ArrayList;

public class MajorityNumber2 {

	int majorityNumber(ArrayList<Integer> nums) {
		int n1 = 0, n2 = 0, count1 = 0, count2 = 0;
		for (int i : nums) {
			if (count1 != 0 && i == n1) {
				++count1;
			} else if (count2 != 0 && i == n2) {
				++count2;
			} else if (count1 == 0) {
				n1 = i;
				++count1;
			} else if (count2 == 0) {
				n2 = i;
				++count2;
			} else {
				--count1;
				--count2;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i : nums) {
			if (i == n1) {
				++count1;
			} else if (i == n2) {
				++count2;
			}
		}
		return count1 > count2 ? n1 : n2;
	}

}
