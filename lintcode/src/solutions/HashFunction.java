package solutions;

public class HashFunction {

	int hashCode(char[] key, int HASH_SIZE) {
		long ret = 0, base = 1;
		for (int i = key.length - 1; i >= 0; --i) {
			ret += key[i] * base;
			base *= 33;
			if (base > HASH_SIZE) {
				base %= HASH_SIZE;
			}
		}
		return (int) (ret % HASH_SIZE);
	}

	public static void main(String[] args) {
		System.out.println(new HashFunction().hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(), 2607));
	}

}
