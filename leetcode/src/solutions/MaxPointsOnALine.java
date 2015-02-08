package solutions;

import java.util.HashMap;
import java.util.Map;

import struct.Point;

public class MaxPointsOnALine {

	int maxPoints(Point[] points) {
		int ret = 0;
		Map<Double, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; ++i) {
			int same = 1;
			map.clear();
			for (int j = i + 1; j < points.length; ++j) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					++same;
				} else {
					double k = Double.POSITIVE_INFINITY;
					if (points[i].x != points[j].x) {
						if (points[i].y == points[j].y) {
							k = 0;
						} else {
							k = (points[j].y - points[i].y) * 1.0 / (points[j].x - points[i].x);
						}
					}
					map.put(k, map.containsKey(k) ? map.get(k) + 1 : 1);
				}
			}
			for (int num : map.values()) {
				ret = Math.max(num + same, ret);
			}
			ret = Math.max(same, ret);
		}
		return ret;
	}

}
