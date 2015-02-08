package solutions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<>();
		if (numRows >= 1) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			ret.add(list);
			for (int i = 1; i < numRows; ++i) {
				list = new ArrayList<>();
				list.add(1);
				for (int j = 0, size = i - 1; j < size; ++j) {
					list.add(ret.get(i - 1).get(j) + ret.get(i - 1).get(j + 1));
				}
				list.add(1);
				ret.add(list);
			}
		}
		return ret;
	}

}
