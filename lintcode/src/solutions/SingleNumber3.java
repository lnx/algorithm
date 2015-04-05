package solutions;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber3 {

	List<Integer> singleNumberIII(int[] a) {
		List<Integer> ret = new ArrayList<>();
		int xor = 0;
		for (int i : a) {
			xor ^= i;
		}
		int x = 0, y = 0, mask = -xor & xor;
		for (int i : a) {
			if ((i & mask) == 0) {
				x ^= i;
			} else {
				y ^= i;
			}
		}
		ret.add(x);
		ret.add(y);
		return ret;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 4, 4, 5, 3 };
		System.out.println(new SingleNumber3().singleNumberIII(a));
	}

}
