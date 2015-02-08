package solutions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		if (rowIndex >= 0) {
			ret.add(1);
			for (int i = 1; i <= rowIndex; ++i) {
				for (int j = 0, size = i - 1; j < size; ++j) {
					ret.set(j, ret.get(j) + ret.get(j + 1));
				}
				ret.add(0, 1);
			}
		}
		return ret;
	}

}
