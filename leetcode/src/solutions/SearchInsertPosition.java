package solutions;

public class SearchInsertPosition {

	int searchInsert(int[] a, int v) {
		int low = -1, high = a.length;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (v > a[mid]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high;
	}

	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] a = { 1, 3, 5, 6 };
		System.out.println(sip.searchInsert(a, 2));
	}

}
