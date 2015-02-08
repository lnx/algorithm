package solutions;

import java.util.ArrayList;
import java.util.List;

import struct.Interval;

public class InsertInterval {

	List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<>();
		int i = 0, size = intervals.size();
		while (i < size && newInterval.start > intervals.get(i).start) {
			++i;
		}
		intervals.add(i, newInterval);
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (i = 1, size = intervals.size(); i < size; ++i) {
			if (end >= intervals.get(i).start) {
				end = Math.max(intervals.get(i).end, end);
			} else {
				ret.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}

}
