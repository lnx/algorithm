package solutions;

public class SearchForARange {

	int[] searchRange(int[] a, int key) {
		int[] ret = { -1, -1 };
		int left = leftSearch(a, key, 0, a.length - 1);
		if (left != -1) {
			ret[0] = left;
			ret[1] = rightSearch(a, key, left, a.length - 1);
		}
		return ret;
	}

	int leftSearch(int[] a, int key, int start, int end) {
		int lo = start - 1, hi = end + 1;
		while (lo + 1 < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (key > a[mid]) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return hi < a.length && a[hi] == key ? hi : -1;
	}

	int rightSearch(int[] a, int key, int start, int end) {
		int lo = start - 1, hi = end + 1;
		while (lo + 1 < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (key >= a[mid]) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return lo >= start && a[lo] == key ? lo : -1;
	}

	public static void main(String[] args) {
		SearchForARange sfa = new SearchForARange();
		int[] a = { 5, 7, 7, 8, 8, 10 };
		int v = 8;
		int[] range = sfa.searchRange(a, v);
		for (int r : range) {
			System.out.print(r + " ");
		}
	}

}
