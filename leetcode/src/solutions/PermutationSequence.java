package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationSequence {

	Map<Integer, Integer> map = new HashMap<>();

	String getPermutation(int n, int k) {
		List<Integer> num = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			num.add(i);
		}
		--k;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			int index = k / factorial(n - i - 1);
			sb.append(num.remove(index));
			k %= factorial(n - i - 1);
		}
		return sb.toString();
	}

	int factorial(int n) {
		if (!map.containsKey(n)) {
			int ret = 1;
			for (int i = 1; i <= n; ++i) {
				ret *= i;
			}
			map.put(n, ret);
		}
		return map.get(n);
	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3, 1));
	}

}
