package solutions;

public class AddBinary {

	String addBinary(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		for (int i = s1.length() - 1, j = s2.length() - 1, carry = 0; i >= 0 || j >= 0 || carry > 0;) {
			int num1 = i >= 0 ? s1.charAt(i--) - '0' : 0;
			int num2 = j >= 0 ? s2.charAt(j--) - '0' : 0;
			carry += num1 + num2;
			sb.insert(0, carry % 2);
			carry /= 2;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11", "1"));
	}

}
