package solutions;

public class MajorityElement {

	int majorityElement(int[] nums) {
		int pos = 0, count = 1;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[pos]) {
				++count;
			} else {
				if (--count == 0) {
					pos = i;
					count = 1;
				}
			}
		}
		return nums[pos];
	}

}
