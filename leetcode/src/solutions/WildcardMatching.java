package solutions;

public class WildcardMatching {

	// only this could pass all the test cases
	boolean isMatch(String s, String p) {
		s += '\0';
		p += '\0';
		int sPre = -1, sIdx = 0, pPre = -1, pIdx = 0;
		while (s.charAt(sIdx) != '\0') {
			if (p.charAt(pIdx) == '*') {
				while (p.charAt(pIdx) == '*') {
					++pIdx;
				}
				if (p.charAt(pIdx) == '\0') {
					return true;
				}
				sPre = sIdx;
				pPre = pIdx;
			} else {
				if (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx)) {
					++sIdx;
					++pIdx;
				} else {
					if (sPre >= 0) {
						sIdx = ++sPre;
						pIdx = pPre;
					} else {
						return false;
					}
				}
			}
		}
		while (p.charAt(pIdx) == '*') {
			++pIdx;
		}
		return p.charAt(pIdx) == '\0';
	}

	boolean isMatch1(String s, String p) {
		int slen = s.length(), plen = p.length();
		if (plen == 0) {
			return slen == 0;
		} else {
			if (p.charAt(0) == '*') {
				int i = -1;
				while (++i < plen && p.charAt(i) == '*')
					;
				return isMatch1(s, p.substring(i)) || (slen > 0 && isMatch1(s.substring(1), p));
			} else {
				return slen > 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && isMatch1(s.substring(1), p.substring(1));
			}
		}
	}

	boolean isMatch2(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		boolean[][] matches = new boolean[slen + 1][plen + 1];
		matches[0][0] = true;
		for (int i = 1; i <= plen; ++i) {
			matches[0][i] = matches[0][i - 1] && p.charAt(i - 1) == '*';
		}
		for (int i = 1; i <= slen; ++i) {
			for (int j = 1; j <= plen; ++j) {
				if (p.charAt(j - 1) == '*') {
					matches[i][j] = matches[i - 1][j] || matches[i][j - 1];
				} else {
					matches[i][j] = matches[i - 1][j - 1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
				}
			}
		}
		return matches[slen][plen];
	}

	boolean isMatch3(String s, String p) {
		int slen = s.length(), plen = p.length();
		boolean[] matches = new boolean[slen + 1];
		matches[0] = true;
		for (int i = 1; i <= plen; ++i) {
			if (p.charAt(i - 1) == '*') {
				matches[0] = matches[0] && (p.charAt(i - 1) == '*');
				for (int j = 1; j <= slen; ++j) {
					matches[j] = matches[j] || matches[j - 1];
				}
			} else {
				for (int j = slen; j >= 1; --j) {
					matches[j] = matches[j - 1] && (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1));
				}
				matches[0] = matches[0] && (p.charAt(i - 1) == '*');
			}
		}
		return matches[slen];
	}

	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();

		System.out.println(wm.isMatch("aa", "a"));
		System.out.println(wm.isMatch("aa", "aa"));
		System.out.println(wm.isMatch("aaa", "aa"));
		System.out.println(wm.isMatch("aa", "*"));
		System.out.println(wm.isMatch("aa", "a*"));
		System.out.println(wm.isMatch("ab", "?*"));
		System.out.println(wm.isMatch("aab", "c*a*b") + "\n");

		System.out.println(wm.isMatch1("aa", "a"));
		System.out.println(wm.isMatch1("aa", "aa"));
		System.out.println(wm.isMatch1("aaa", "aa"));
		System.out.println(wm.isMatch1("aa", "*"));
		System.out.println(wm.isMatch1("aa", "a*"));
		System.out.println(wm.isMatch1("ab", "?*"));
		System.out.println(wm.isMatch1("aab", "c*a*b") + "\n");

		System.out.println(wm.isMatch2("aa", "a"));
		System.out.println(wm.isMatch2("aa", "aa"));
		System.out.println(wm.isMatch2("aaa", "aa"));
		System.out.println(wm.isMatch2("aa", "*"));
		System.out.println(wm.isMatch2("aa", "a*"));
		System.out.println(wm.isMatch2("ab", "?*"));
		System.out.println(wm.isMatch2("aab", "c*a*b") + "\n");

		System.out.println(wm.isMatch3("aa", "a"));
		System.out.println(wm.isMatch3("aa", "aa"));
		System.out.println(wm.isMatch3("aaa", "aa"));
		System.out.println(wm.isMatch3("aa", "*"));
		System.out.println(wm.isMatch3("aa", "a*"));
		System.out.println(wm.isMatch3("ab", "?*"));
		System.out.println(wm.isMatch3("aab", "c*a*b") + "\n");
	}

}
