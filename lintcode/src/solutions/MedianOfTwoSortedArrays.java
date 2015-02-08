package solutions;

public class MedianOfTwoSortedArrays {

	double findMedianSortedArrays(int[] a, int[] b) {
		int len = a.length + b.length;
		if (len % 2 == 0) {
			return (findKth(a, b, 0, 0, len / 2) + findKth(a, b, 0, 0, len / 2 + 1)) / 2.0;
		} else {
			return findKth(a, b, 0, 0, len / 2 + 1);
		}
	}

	int findKth(int[] a, int[] b, int as, int bs, int k) {
		if (as == a.length) {
			return b[bs + k - 1];
		}
		if (bs == b.length) {
			return a[as + k - 1];
		}
		if (k == 1) {
			return a[as] < b[bs] ? a[as] : b[bs];
		}
		int ai = as + k / 2 - 1;
		int bi = bs + (k - k / 2) - 1;
		int ak = ai < a.length ? a[ai] : Integer.MAX_VALUE;
		int bk = bi < b.length ? b[bi] : Integer.MAX_VALUE;
		return ak < bk ? findKth(a, b, ai + 1, bs, k - (ai - as + 1)) : findKth(a, b, as, bi + 1, k - (bi - bs + 1));
	}

}
