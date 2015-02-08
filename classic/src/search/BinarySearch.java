package search;

public class BinarySearch {

	int search(int[] a, int key) {
		int low = -1, high = a.length;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (key > a[mid]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high < a.length && a[high] == key ? high : -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 4, 5 };
		System.out.println(new BinarySearch().search(a, 4));
	}

}
