package solutions;

public class SqrtX {

	int sqrt(int x) {
		int count = 0;
		double x0 = 0x5f3759df;
		while (true) {
			double x1 = (x0 + x / x0) / 2.0;
			System.out.println(++count + ": " + x1);
			if (Math.abs(x1 - x0) < 1) {
				return (int) x1;
			}
			x0 = x1;
		}
	}

	public static void main(String[] args) {
		System.out.println("\n" + new SqrtX().sqrt(1000));
	}

}
