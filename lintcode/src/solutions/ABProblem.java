package solutions;

public class ABProblem {

	int aplusb(int a, int b) {
		int sum = 0;
		for (int i = 0, carry = 0; i < Integer.SIZE; ++i) {
			int count = 0;
			int mask = 1 << i;
			if (carry != 0) {
				++count;
			}
			if ((a & mask) != 0) {
				++count;
			}
			if ((b & mask) != 0) {
				++count;
			}
			switch (count) {
			case 0:
				carry = 0;
				break;
			case 1:
				sum |= mask;
				carry = 0;
				break;
			case 2:
				carry = 1;
				break;
			case 3:
				sum |= mask;
				carry = 1;
				break;
			default:
				break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		System.out.println(new ABProblem().aplusb(a, b));
	}

}
