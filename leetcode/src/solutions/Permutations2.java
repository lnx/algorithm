package solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

	List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ret = new ArrayList<>();
		dfs(num, 0, ret);
		return ret;
	}

	void dfs(int[] num, int k, List<List<Integer>> ret) {
		if (k == num.length) {
			List<Integer> list = new ArrayList<>();
			for (int i : num) {
				list.add(i);
			}
			ret.add(list);
		} else {
			for (int i = k; i < num.length; ++i) {
				boolean dup = false;
				for (int j = k; j < i; ++j) {
					if (num[j] == num[i]) {
						dup = true;
						break;
					}
				}
				if (!dup) {
					swap(num, k, i);
					dfs(num, k + 1, ret);
					swap(num, k, i);
				}
			}
		}
	}

	void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) {
		int[] num = { 1, 1 };
		List<List<Integer>> ret = new Permutations2().permuteUnique(num);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

}
