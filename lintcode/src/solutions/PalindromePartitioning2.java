package solutions;

public class PalindromePartitioning2 {

	int minCut(String s) {
		int len = s.length();
		int[] cut = new int[len];
		boolean[][] palindrome = getPalindrome(s);
		for (int j = 1; j < len; ++j) {
			cut[j] = j;
			for (int i = 0; i <= j; ++i) {
				if (palindrome[i][j]) {
					if (i == 0) {
						cut[j] = 0;
						break;
					} else {
						cut[j] = Math.min(cut[j], cut[i - 1] + 1);
					}
				}
			}
		}
		return cut[len - 1];
	}

	boolean[][] getPalindrome(String s) {
		int len = s.length();
		boolean[][] palindrome = new boolean[len][len];
		for (int j = 0; j < len; ++j) {
			for (int i = 0; i <= j; ++i) {
				palindrome[i][j] = s.charAt(i) == s.charAt(j);
				if (i + 2 < j) {
					palindrome[i][j] &= palindrome[i + 1][j - 1];
				}
			}
		}
		return palindrome;
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}

}
