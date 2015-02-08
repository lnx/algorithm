package solutions;

public class SearchInRotatedSortedArray {

	int search(int[] a, int key) {
		int lo = 0, hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (a[lo] < a[mid]) {
				if (a[lo] <= key && key < a[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (a[lo] > a[mid]) {
				if (a[mid] < key && key <= a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				++lo;
			}
		}
		return -1;
	}

}
