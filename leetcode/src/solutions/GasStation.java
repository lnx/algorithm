package solutions;

public class GasStation {

	int canCompleteCircuit(int[] gas, int[] cost) {
		int left = 0, pos = 0;
		for (int i = 0, cur = 0; i < gas.length; ++i) {
			left += gas[i] - cost[i];
			cur += gas[i] - cost[i];
			if (cur < 0) {
				cur = 0;
				pos = i + 1;
			}
		}
		return left >= 0 ? pos : -1;
	}

	public static void main(String[] args) {
		int[] gas = { 5 };
		int[] cost = { 4 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}

}
