package amazon;

public class PeakValley {

	int maxDistance(int[] a) {
		int ret = Integer.MIN_VALUE;
		int pre = 0;
		for (int i = 1; i < a.length - 1; ++i) {
			if (!((a[i - 1] <= a[i] && a[i] <= a[i + 1]) || (a[i - 1] >= a[i] && a[i] >= a[i + 1]))) {
				ret = Math.max(ret, Math.abs(a[i] - a[pre]));
				pre = i;
			}
		}
		ret = Math.max(ret, Math.abs(a[a.length - 1] - a[pre]));
		return ret;
	}

	public static void main(String[] args) {
		PeakValley pv = new PeakValley();
		int[][] inputs = { { 2, 3, 6, 5, 7, 9 }, { 2, 3, 6, 5, 7 }, { 2, 3, 6, 5, 7, 9, 10 } };
		System.out.print(pv.maxDistance(inputs[0]));
		for (int i = 1; i < inputs.length; ++i) {
			System.out.print("," + pv.maxDistance(inputs[i]));
		}
	}

}
