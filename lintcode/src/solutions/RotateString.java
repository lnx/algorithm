package solutions;

public class RotateString {

	char[] rotateString(char[] chs, int offset) {
		if (chs.length > 0) {
			offset %= chs.length;
			if (offset > 0) {
				reverse(chs, 0, chs.length);
				reverse(chs, 0, offset);
				reverse(chs, offset, chs.length - offset);
			}
		}
		return chs;
	}

	void reverse(char[] chs, int offset, int len) {
		for (int i = offset, j = offset + len - 1; i < j; ++i, --j) {
			char t = chs[i];
			chs[i] = chs[j];
			chs[j] = t;
		}
	}

}
