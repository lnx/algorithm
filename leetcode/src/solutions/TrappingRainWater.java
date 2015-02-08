package solutions;

public class TrappingRainWater {

	int trap(int[] a) {
		if (a == null || a.length <= 2) {
			return 0;
		}
		int water = 0;
		int highest = 0;
		for (int i = 1; i < a.length; ++i) {
			if (a[i] > a[highest]) {
				highest = i;
			}
		}
		int leftHigh = a[0];
		for (int i = 1; i < highest; ++i) {
			if (a[i] > leftHigh) {
				leftHigh = a[i];
			} else {
				water += leftHigh - a[i];
			}
		}
		int rightHigh = a[a.length - 1];
		for (int i = a.length - 2; i > highest; --i) {
			if (a[i] > rightHigh) {
				rightHigh = a[i];
			} else {
				water += rightHigh - a[i];
			}
		}
		return water;
	}

	public static void main(String[] args) {
		int[] a = { 4, 2, 3 };
		System.out.println(new TrappingRainWater().trap(a));
	}

}
