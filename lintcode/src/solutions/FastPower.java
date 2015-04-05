package solutions;

import java.util.HashMap;
import java.util.Map;

public class FastPower {

	Map<Integer, Integer> map = new HashMap<>();

	int fastPower(int a, int b, int n) {
		if (!map.containsKey(n)) {
			if (n == 0) {
				map.put(n, 1 % b);
			} else if (n == 1) {
				map.put(n, a % b);
			} else {
				map.put(n, (int) (((long) fastPower(a, b, n / 2) * fastPower(a, b, n - n / 2)) % b));
			}
		}
		return map.get(n);
	}

	public static void main(String[] args) {
		System.out.println(new FastPower().fastPower(2, Integer.MAX_VALUE, Integer.MAX_VALUE));
	}

}
