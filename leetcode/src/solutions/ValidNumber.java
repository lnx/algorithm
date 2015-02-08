package solutions;

public class ValidNumber {

	boolean isNumber(String s) {
		return s != null && s.trim().matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?");
	}

	public static void main(String[] args) {
		System.out.println(new ValidNumber().isNumber(".2e81"));
	}

}
