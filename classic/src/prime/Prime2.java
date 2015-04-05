package prime;

public class Prime2 {

	boolean valid(int num) {
		return num >= 0 && !String.format("%0" + num + "d", 0).matches("^0?$|^(00+?)\\1+$");
	}

	public static void main(String[] args) {
		System.out.println(new Prime2().valid(1));
		System.out.println(new Prime2().valid(2));
		System.out.println(new Prime2().valid(3));
		System.out.println(new Prime2().valid(4));
		System.out.println(new Prime2().valid(5));
	}

}
