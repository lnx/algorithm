package solutions;

import java.util.Arrays;

public class ThreeSumClosest {

	int threeSumClosest(int[] a, int target) {
		Arrays.sort(a);
		int ret = a[0] + a[1] + a[2];
		for (int i = 0, size = a.length - 2; i < size; ++i) {
			for (int rest = target - a[i], left = i + 1, right = a.length - 1; left < right;) {
				int sum = a[left] + a[right];
				if (sum == rest) {
					return target;
				} else {
					if (sum < rest) {
						++left;
					} else {
						--right;
					}
					sum += a[i];
					if (Math.abs(target - sum) < Math.abs(target - ret)) {
						ret = sum;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] num = { -1, 2, 1, -4 };
		int target = 1;
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, target));
	}

}
