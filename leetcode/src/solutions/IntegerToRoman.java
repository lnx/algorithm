package solutions;

public class IntegerToRoman {

	String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		int digitM = num / 1000;
		append(sb, 'M', digitM);
		num %= 1000;

		int digitC = num / 100;
		if (digitC <= 3) {
			append(sb, 'C', digitC);
		} else if (digitC == 4) {
			append(sb, 'C', 1);
			append(sb, 'D', 1);
		} else if (digitC >= 5 && digitC <= 8) {
			append(sb, 'D', 1);
			append(sb, 'C', digitC - 5);
		} else if (digitC == 9) {
			append(sb, 'C', 1);
			append(sb, 'M', 1);
		}
		num %= 100;

		int digitX = num / 10;
		if (digitX <= 3) {
			append(sb, 'X', digitX);
		} else if (digitX == 4) {
			append(sb, 'X', 1);
			append(sb, 'L', 1);
		} else if (digitX >= 5 && digitX <= 8) {
			append(sb, 'L', 1);
			append(sb, 'X', digitX - 5);
		} else if (digitX == 9) {
			append(sb, 'X', 1);
			append(sb, 'C', 1);
		}
		num %= 10;

		int digitI = num;
		if (digitI <= 3) {
			append(sb, 'I', digitI);
		} else if (digitI == 4) {
			append(sb, 'I', 1);
			append(sb, 'V', 1);
		} else if (digitI >= 5 && digitI <= 8) {
			append(sb, 'V', 1);
			append(sb, 'I', digitI - 5);
		} else if (digitI == 9) {
			append(sb, 'I', 1);
			append(sb, 'X', 1);
		}

		return sb.toString();
	}

	void append(StringBuilder sb, char c, int times) {
		for (int i = 0; i < times; ++i) {
			sb.append(c);
		}
	}

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(10));
	}

}
