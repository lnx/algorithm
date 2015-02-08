package solutions;

public class PalindromeNumber {

	boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int divide = 1;
		while (x / divide >= 10) {
			divide *= 10;
		}
		while (x > 0) {
			int high = x / divide;
			int low = x % 10;
			if (high != low) {
				return false;
			} else {
				x = (x % divide) / 10;
				divide /= 100;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(1000021));
	}

}
