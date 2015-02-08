package solutions;

public class SearchInRotatedSortedArray2 {

	boolean search(int[] a, int target) {
		int low = 0, high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == a[mid]) {
				return true;
			}
			if (a[low] < a[mid]) {
				if (a[low] <= target && target < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[low] > a[mid]) {
				if (a[mid] < target && target <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				++low;
			}
		}
		return false;
	}

}
