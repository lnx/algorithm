package solutions;

public class RemoveDuplicatesFromSortedArray {

	int removeDuplicates(int[] nums) {
		int remove = 0;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1 - remove]) {
				++remove;
			} else {
				nums[i - remove] = nums[i];
			}
		}
		return nums.length - remove;
	}

}
