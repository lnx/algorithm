package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	List<List<Integer>> fourSum(int[] a, int target) {
		Arrays.sort(a);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0, isize = a.length - 3; i < isize; ++i) {
			if (i == 0 || a[i] > a[i - 1]) {
				for (int j = i + 1, jsize = a.length - 2; j < jsize; ++j) {
					if (j == i + 1 || a[j] > a[j - 1]) {
						for (int rest = target - a[i] - a[j], left = j + 1, right = a.length - 1; left < right;) {
							int sum = a[left] + a[right];
							if (sum == rest) {
								List<Integer> list = new ArrayList<>();
								list.add(a[i]);
								list.add(a[j]);
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
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		FourSum fs = new FourSum();
		List<List<Integer>> ret = fs.fourSum(num, target);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
