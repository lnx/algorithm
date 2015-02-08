package solutions;

public class ContainerWithMostWater {

	int maxArea(int[] a) {
		int ret = 0;
		for (int left = 0, right = a.length - 1; left < right;) {
			if (a[left] <= a[right]) {
				ret = Math.max((right - left) * a[left], ret);
				int cur = a[left];
				while (left < right && a[left] <= cur) {
					++left;
				}
			} else {
				ret = Math.max((right - left) * a[right], ret);
				int cur = a[right];
				while (left < right && a[right] <= cur) {
					--right;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] height = { 1, 1 };
		ContainerWithMostWater o = new ContainerWithMostWater();
		System.out.println(o.maxArea(height));
	}

}
