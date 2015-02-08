package solutions;

public class ValidPalindrome {

	boolean isPalindrome(String s) {
		s = s.toLowerCase();
		for (int i = 0, j = s.length() - 1; i < j;) {
			while (i < j && !isLetter(s.charAt(i))) {
				++i;
			}
			while (i < j && !isLetter(s.charAt(j))) {
				--j;
			}
			if (i < j && s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	boolean isLetter(char c) {
		return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
	}

}
