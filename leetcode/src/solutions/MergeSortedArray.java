package solutions;

public class MergeSortedArray {

	void merge(int a[], int m, int b[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			a[k--] = a[i] > b[j] ? a[i--] : b[j--];
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}

}
