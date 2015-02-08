package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import struct.Interval;

public class MergeIntervals {

	List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<>();
		if (intervals.size() == 0) {
			return ret;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start) {
					return -1;
				} else if (i1.start == i2.start) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (int i = 1, size = intervals.size(); i < size; ++i) {
			Interval cur = intervals.get(i);
			if (end >= cur.start) {
				end = Math.max(end, cur.end);
			} else {
				ret.add(new Interval(start, end));
				start = cur.start;
				end = cur.end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}

}
