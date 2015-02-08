package solutions;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 0, size = 1 << n; i < size; ++i) {
			ret.add((i >> 1) ^ i);
		}
		return ret;
	}

}
