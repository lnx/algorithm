package solutions;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> ret = new ArrayList<>();
		int height = triangle.size();
		if (height > 0) {
			ret.addAll(triangle.get(height - 1));
			for (int i = height - 2; i >= 0; --i) {
				List<Integer> list = triangle.get(i);
				for (int j = 0, size = list.size(); j < size; ++j) {
					ret.set(j, list.get(j) + Math.min(ret.get(j), ret.get(j + 1)));
				}
			}
		}
		return ret.size() > 0 ? ret.get(0) : Integer.MAX_VALUE;
	}

}
