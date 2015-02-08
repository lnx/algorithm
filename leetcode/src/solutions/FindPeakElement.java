package solutions;

public class FindPeakElement {

	int findPeakElement(int[] num) {
		if (num.length == 0) {
			return -1;
		}
		if (num.length == 1) {
			return 0;
		}
		int i = 0;
		while (i < num.length - 1) {
			if (num[i] > num[i + 1]) {
				return i;
			}
			++i;
		}
		return i;
	}

}
