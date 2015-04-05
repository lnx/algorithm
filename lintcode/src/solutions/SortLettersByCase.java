package solutions;

public class SortLettersByCase {

	void sortLetters(char[] chs) {
		int i = 0, j = chs.length - 1;
		while (true) {
			while (i < j && chs[i] >= 'a' && chs[i] <= 'z') {
				++i;
			}
			while (i < j && chs[j] >= 'A' && chs[j] <= 'Z') {
				--j;
			}
			if (i < j) {
				swap(chs, i, j);
			} else {
				break;
			}
		}
	}

	void swap(char[] chs, int i, int j) {
		char t = chs[i];
		chs[i] = chs[j];
		chs[j] = t;
	}
	
	public static void main(String[] args) {
		char[] chs = "aAAADEFFFFJJJJKKKKKKLLLLR".toCharArray();
		new SortLettersByCase().sortLetters(chs);
	}

}
