package solutions;

public class JumpGame2 {

	int jump(int[] a) {
		int ret = 0;
		int last = 0, farthest = 0;
		for (int i = 0; i < a.length && farthest < a.length - 1; ++i) {
			if (i > last) {
				last = farthest;
				++ret;
			}
			farthest = Math.max(i + a[i], farthest);
		}
		return last >= a.length - 1 ? ret : ret + 1;
	}

	public static void main(String[] args) {
		int[] a = { 1 };
		System.out.println(new JumpGame2().jump(a));
	}

}
