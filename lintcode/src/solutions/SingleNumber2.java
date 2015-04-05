package solutions;

public class SingleNumber2 {
	
    public int singleNumberII(int[] a) {
    	int ret = 0;
    	for (int i = 0; i < Integer.SIZE; ++i) {
    		int sum = 0, mask = 1 << i;
    		for (int j : a) {
    			if ((j & mask) != 0) {
    				++sum;
    			}
    		}
    		if (sum % 3 != 0) {
    			ret += mask;
    		}
    	}
    	return ret;
    }

}
