package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	List<List<Integer>> threeSum(int[] a) {
		Arrays.sort(a);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0, size = a.length - 2; i < size && a[i] <= 0; ++i) {
			if (i == 0 || a[i] > a[i - 1]) {
				for (int rest = -a[i], left = i + 1, right = a.length - 1; left < right;) {
					int sum = a[left] + a[right];
					if (sum == rest) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(a[i]);
						list.add(a[left]);
						list.add(a[right]);
						ret.add(list);
						while (++left < right && a[left] == a[left - 1])
							;
						while (left < --right && a[right] == a[right + 1])
							;
					} else if (sum < rest) {
						++left;
					} else {
						--right;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> ret = new ThreeSum().threeSum(num);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
