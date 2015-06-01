package solutions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

	boolean containsNearbyDuplicate(int[] a, int k) {
		Set<Integer> set = new HashSet<>();
		k = Math.min(k, a.length - 1);
		for (int i = 0; i <= k; ++i) {
			if (set.contains(a[i])) {
				return true;
			}
			set.add(a[i]);
		}
		for (int i = k + 1; i < a.length; ++i) {
			set.remove(a[i - k - 1]);
			if (set.contains(a[i])) {
				return true;
			}
			set.add(a[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate2 o = new ContainsDuplicate2();
		int[] a = { -1, -1 };
		int k = 1;
		System.out.println(o.containsNearbyDuplicate(a, k));
	}

}
