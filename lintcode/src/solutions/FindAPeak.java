package solutions;

public class FindAPeak {

	int findPeak(int[] a) {
		int low = 0, high = a.length - 1;
		while (low < high) {
			int mid1 = low + (high - low) / 2;
			int mid2 = mid1 + 1;
			if (a[mid1] < a[mid2]) {
				low = mid2;
			} else {
				high = mid1;
			}
		}
		return low;
	}

}
