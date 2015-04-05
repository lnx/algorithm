package indeed;

import java.util.Scanner;

public class Rotation {

	static void rotate(char[] chs, int l, int r, int k) {
		int size = r - l + 1;
		k %= size;
		if (k != 0) {
			reverse(chs, l - 1, r - k - 1);
			reverse(chs, r - k, r - 1);
			reverse(chs, l - 1, r - 1);
		}
	}

	static void reverse(char[] chs, int left, int right) {
		for (; left < right; ++left, --right) {
			char temp = chs[left];
			chs[left] = chs[right];
			chs[right] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String s = sc.next();
		int m = sc.nextInt();
		char[] chs = s.toCharArray();
		for (int i = 0; i < m; ++i) {
			int l = sc.nextInt(), r = sc.nextInt(), k = sc.nextInt();
			rotate(chs, l, r, k);
		}
		System.out.println(chs);
		sc.close();
	}

}
