package solutions;

public class StrStr {

	int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		int slen = source.length(), tlen = target.length();
		for (int i = 0; i <= slen - tlen; ++i) {
			boolean found = true;
			for (int j = 0; j < tlen; ++j) {
				if (source.charAt(i + j) != target.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found) {
				return i;
			}
		}
		return -1;
	}

}
