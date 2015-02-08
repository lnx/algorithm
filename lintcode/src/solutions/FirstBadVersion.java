package solutions;

public class FirstBadVersion {

	int findFirstBadVersion(int n) {
		int low = 0, high = n + 1;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high;
	}

	boolean isBadVersion(int i) {
		return true;
	}

}
