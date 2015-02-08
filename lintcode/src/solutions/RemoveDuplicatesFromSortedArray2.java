package solutions;

public class RemoveDuplicatesFromSortedArray2 {

	int removeDuplicates(int[] nums) {
		int remove = 0;
		for (int i = 2; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1 - remove] && nums[i] == nums[i - 2 - remove]) {
				++remove;
			} else {
				nums[i - remove] = nums[i];
			}
		}
		return nums.length - remove;
	}

}
