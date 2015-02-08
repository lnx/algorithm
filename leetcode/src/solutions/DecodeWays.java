package solutions;

public class DecodeWays {

	int numDecodings(String s) {
		int len = s.length();
		if (len <= 1) {
			return len == 0 || !canDecode(s.charAt(0)) ? 0 : 1;
		}
		int a0 = canDecode(s.charAt(0)) ? 1 : 0;
		int a1 = (canDecode(s.charAt(0), s.charAt(1)) ? 1 : 0) + (canDecode(s.charAt(1)) ? a0 : 0);
		for (int i = 2; i < len; ++i) {
			int next = (canDecode(s.charAt(i - 1), s.charAt(i)) ? a0 : 0) + (canDecode(s.charAt(i)) ? a1 : 0);
			a0 = a1;
			a1 = next;
		}
		return a1;
	}

	boolean canDecode(char c) {
		return c != '0';
	}

	boolean canDecode(char c1, char c2) {
		return c1 == '1' || (c1 == '2' && c2 <= '6');
	}

}
