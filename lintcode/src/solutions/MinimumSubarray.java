package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSubarray {
	
    int minSubArray(ArrayList<Integer> nums) {
    	int size = nums.size();
    	if (size == 0) {
    		return 0;
    	}
    	int min = nums.get(0);
    	for (int i = 1, sum = nums.get(0); i < size; ++i) {
    		sum = Math.min(sum + nums.get(i), nums.get(i));
    		min = Math.min(min, sum);
    	}
    	return min;
    }
    
    public static void main(String[] args) {
		Integer[] a = {1, -1, -2, 1};
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a));
		System.out.println(new MinimumSubarray().minSubArray(nums));
	}

}
