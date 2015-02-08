package solutions;

public class JumpGame {

	boolean canJump(int[] a) {
		for (int i = 0, last = 0; i <= last; ++i) {
			if (last >= a.length - 1) {
				return true;
			}
			last = Math.max(last, i + a[i]);
		}
		return false;
	}

}
