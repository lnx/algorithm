package solutions;

public class RemoveDuplicatesFromSortedArray2 {

	int removeDuplicates(int[] a) {
		int dup = 0;
		for (int i = 2; i < a.length; ++i) {
			if (a[i] == a[i - dup - 1] && a[i] == a[i - dup - 2]) {
				++dup;
			} else {
				a[i - dup] = a[i];
			}
		}
		return a.length - dup;
	}

}
