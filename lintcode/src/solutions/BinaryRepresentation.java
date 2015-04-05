package solutions;

public class BinaryRepresentation {

	String binaryRepresentation(String s) {
		int dotPos = s.indexOf('.');
		StringBuilder intBuf = new StringBuilder();
		int integer = Integer.parseInt(s.substring(0, dotPos));
		do {
			intBuf.insert(0, integer & 1);
			integer >>= 1;
		} while (integer > 0);
		StringBuilder decBuf = new StringBuilder();
		double decimal = Double.parseDouble(s.substring(dotPos));
		while (decimal > 0.0) {
			if (decBuf.length() > Integer.SIZE) {
				return "ERROR";
			}
			decimal *= 2;
			if (decimal >= 1.0) {
				decBuf.append(1);
				decimal -= 1.0;
			} else {
				decBuf.append(0);
			}
		}
		return decBuf.length() == 0 ? intBuf.toString() : intBuf.toString() + "." + decBuf.toString();
	}

}
