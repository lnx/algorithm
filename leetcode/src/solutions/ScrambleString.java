package solutions;

public class ScrambleString {

	boolean isScramble(String s1, String s2) {
		int len = s1.length() == s2.length() ? s1.length() : -1;
		if (len <= 0) {
			return len == 0;
		}
		boolean[][][] scramble = new boolean[len + 1][len][len];
		for (int l = 1; l <= len; ++l) {
			for (int i = 0; i < len; ++i) {
				for (int j = 0; j < len; ++j) {
					if (l == 1) {
						scramble[l][i][j] = s1.charAt(i) == s2.charAt(j);
					} else if (i + l <= len && j + l <= len) {
						for (int k = 1; k < l && !scramble[l][i][j]; ++k) {
							scramble[l][i][j] = (scramble[k][i][j] && scramble[l - k][i + k][j + k]) || (scramble[k][i][j + l - k] && scramble[l - k][i + k][j]);
						}
					}
				}
			}
		}
		return scramble[len][0][0];
	}

	public static void main(String[] args) {
		System.out.println(new ScrambleString().isScramble("aa", "aa"));
	}

}
