package solutions;

public class RegularExpressionMatching {

	boolean isMatch(String s, String p) {
		int slen = s.length(), plen = p.length();
		if (plen == 0) {
			return slen == 0;
		} else {
			if (plen == 1 || p.charAt(1) != '*') {
				return slen > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
			} else {
				return isMatch(s, p.substring(2)) || (slen > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p));
			}
		}
	}

	boolean isMatch1(String s, String p) {
		int slen = s.length(), plen = p.length();
		boolean[][] matches = new boolean[slen + 1][plen + 1];
		matches[0][0] = true;
		for (int i = 1; i <= plen; ++i) {
			matches[0][i] = i > 1 && p.charAt(i - 1) == '*' && matches[0][i - 2];
		}
		for (int i = 1; i <= slen; ++i) {
			for (int j = 1; j <= plen; ++j) {
				if (j == 1 || p.charAt(j - 1) != '*') {
					matches[i][j] = matches[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
				} else {
					matches[i][j] = matches[i][j - 2] || (matches[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
				}
			}
		}
		return matches[slen][plen];
	}

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();

		System.out.println(rem.isMatch("aa", "a"));
		System.out.println(rem.isMatch("aa", "aa"));
		System.out.println(rem.isMatch("aaa", "aa"));
		System.out.println(rem.isMatch("aa", "a*"));
		System.out.println(rem.isMatch("aa", ".*"));
		System.out.println(rem.isMatch("ab", ".*"));
		System.out.println(rem.isMatch("aab", "c*a*b") + "\n");

		System.out.println(rem.isMatch1("aa", "a"));
		System.out.println(rem.isMatch1("aa", "aa"));
		System.out.println(rem.isMatch1("aaa", "aa"));
		System.out.println(rem.isMatch1("aa", "a*"));
		System.out.println(rem.isMatch1("aa", ".*"));
		System.out.println(rem.isMatch1("ab", ".*"));
		System.out.println(rem.isMatch1("aab", "c*a*b") + "\n");
	}

}
