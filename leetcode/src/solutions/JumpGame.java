package solutions;

public class JumpGame {

	boolean canJump(int[] a) {
		int farthest = 0;
		for (int i = 0; i < a.length && farthest < a.length - 1; ++i) {
			if (i > farthest) {
				return false;
			}
			farthest = Math.max(i + a[i], farthest);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 0 };
		System.out.println(new JumpGame().canJump(a));
	}

}
