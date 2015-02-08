package solutions;

public class FindMinimumInRotatedSortedArray2 {

	int findMin(int[] a) {
		int ret = a[0];
		int left = 0, right = a.length - 1;
		while (left <= right) {
			int center = left + (right - left) / 2;
			if (a[left] <= a[center]) {
				ret = Math.min(a[left], ret);
				if (a[left] == a[center]) {
					++left;
				} else {
					left = center + 1;
				}
			} else {
				right = center;
			}
		}
		return ret;
	}

}
