package solutions;

import java.util.ArrayList;

public class PartitionArray {

	int partitionArray(ArrayList<Integer> nums, int k) {
		int i = 0, j = nums.size() - 1;
		while (true) {
			while (i <= j && nums.get(i) < k) {
				++i;
			}
			while (i <= j && nums.get(j) >= k) {
				--j;
			}
			if (i < j) {
				swap(nums, i, j);
			} else {
				return i;
			}
		}
	}

	void swap(ArrayList<Integer> nums, int i, int j) {
		int t = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, t);
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		int k = 2;
		System.out.println(new PartitionArray().partitionArray(nums, k));
	}

}
