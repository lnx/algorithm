package solutions;

public class Candy {

	int candy(int[] ratings) {
		int len = ratings.length;
		int[] candy = new int[len];
		candy[0] = 1;
		for (int i = 1; i < len; ++i) {
			candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
		}
		int sum = candy[len - 1];
		for (int i = len - 2; i >= 0; --i) {
			if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
			sum += candy[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] ratings = { 4, 2, 3, 4, 1 };
		System.out.println(new Candy().candy(ratings));
	}

}
