package solutions;

public class LongestCommonPrefix {

	String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs[0] == null) {
			return "";
		}
		for (int len = 0;; ++len) {
			for (int i = 0; i < strs.length; ++i) {
				if (strs[i] == null || len >= strs[i].length() || strs[i].charAt(len) != strs[0].charAt(len)) {
					return strs[0].substring(0, len);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] strs = { "hello" };
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(strs));
	}

}
