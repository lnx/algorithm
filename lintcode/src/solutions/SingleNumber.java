package solutions;

public class SingleNumber {
	
	int singleNumber(int[] a) {
		int ret = 0;
		for (int i : a) {
			ret ^= i;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 1, 2 };
		System.out.println(new SingleNumber().singleNumber(a));
	}

}
