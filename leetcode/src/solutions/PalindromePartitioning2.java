package solutions;

public class PalindromePartitioning2 {

	int minCut(String s) {
		int len = s.length();
		int[] cut = new int[len];
		boolean[][] palindrome = getPalindrome(s, len);
		for (int i = 1; i < len; ++i) {
			cut[i] = i;
			for (int j = 0; j <= i; ++j) {
				if (palindrome[j][i]) {
					if (j == 0) {
						cut[i] = 0;
						break;
					} else {
						cut[i] = Math.min(cut[j - 1] + 1, cut[i]);
					}
				}
			}
		}
		return cut[len - 1];
	}

	boolean[][] getPalindrome(String s, int len) {
		boolean[][] palindrome = new boolean[len][len];
		for (int i = len - 1; i >= 0; --i) {
			for (int j = i; j < len; ++j) {
				if (j - i >= 3) {
					palindrome[i][j] = s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1];
				} else {
					palindrome[i][j] = s.charAt(i) == s.charAt(j);
				}
			}
		}
		return palindrome;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning2().minCut("aabb"));
	}

}
