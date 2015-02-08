package solutions;

public class ClimbingStairs {

	int climbStairs(int n) {
		int n0 = 1, n1 = 1;
		for (int i = 2; i <= n; ++i) {
			int next = n0 + n1;
			n0 = n1;
			n1 = next;
		}
		return n1;
	}

}
