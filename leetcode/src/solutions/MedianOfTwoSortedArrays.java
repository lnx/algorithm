package solutions;

public class MedianOfTwoSortedArrays {

	double findMedianSortedArrays(int a[], int b[]) {
		int len = a.length + b.length;
		if (len % 2 == 0) {
			return (findKth(a, b, 0, 0, len / 2) + findKth(a, b, 0, 0, len / 2 + 1)) / 2.0;
		} else {
			return findKth(a, b, 0, 0, len / 2 + 1);
		}
	}

	int findKth(int a[], int b[], int as, int bs, int k) {
		if (as >= a.length) {
			return b[bs + k - 1];
		}
		if (bs >= b.length) {
			return a[as + k - 1];
		}
		if (k == 1) {
			return Math.min(a[as], b[bs]);
		}
		int ak = as + k / 2 <= a.length ? a[as + k / 2 - 1] : Integer.MAX_VALUE;
		int bk = bs + k / 2 <= b.length ? b[bs + k / 2 - 1] : Integer.MAX_VALUE;
		if (ak < bk) {
			return findKth(a, b, as + k / 2, bs, k - k / 2);
		} else {
			return findKth(a, b, as, bs + k / 2, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2 };
		int[] b = { 1, 2 };
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
	}

}
