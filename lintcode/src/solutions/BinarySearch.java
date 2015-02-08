package solutions;

public class BinarySearch {

	int binarySearch(int[] nums, int target) {
		int low = -1, high = nums.length;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (target > nums[mid]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high < nums.length && nums[high] == target ? high : -1;
	}

}
