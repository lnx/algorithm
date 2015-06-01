package solutions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	boolean containsDuplicate(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			if (set.contains(i)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}

}
