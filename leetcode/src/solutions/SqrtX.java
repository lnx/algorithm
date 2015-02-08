package solutions;

public class SqrtX {

	int sqrt(int x) {
		double d0 = 0, d1 = 1;
		do {
			d0 = d1;
			d1 = (d0 + x / d0) / 2.0;
		} while (Math.abs(d1 - d0) >= 1);
		return (int) d1;
	}

	public static void main(String[] args) {
		System.out.println(new SqrtX().sqrt(-1));
	}

}
