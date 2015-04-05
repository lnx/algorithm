package indeed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SumTotal {
	
	// TODO Need to revise

	static final Set<Integer> assigned = new HashSet<>();

	static int n;

	static int[] a;

	static int max = Integer.MIN_VALUE;

	static void search(int k) {
		if (k == n) {
			max = Math.max(max, getProductSum());
		} else {
			for (int i = k; i <= n; ++i) {
				if (i == k || !assigned.contains(i)) {
					swap(k, i);
					search(k + 1);
					swap(k, i);
				}
			}
		}
	}

	static int getProductSum() {
		int sum = 0;
		for (int i = 1; i < n; ++i) {
			sum += a[i] * a[i + 1];
		}
		return sum;
	}

	static void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n + 1];
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			int num = sc.nextInt(), pos = sc.nextInt();
			if (pos == -1) {
				list.add(num);
			} else {
				assigned.add(pos);
				a[pos] = num;
			}
		}
		int index = 1;
		for (int i : list) {
			while (assigned.contains(index)) {
				++index;
			}
			a[index++] = i;
		}
		search(1);
		System.out.println(max);
		sc.close();
	}

}
