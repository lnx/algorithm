package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Hiking {

	static class Mountain {

		int start;
		int end;
		int height;

		public Mountain(int start, int end, int height) {
			this.start = start;
			this.end = end;
			this.height = height;
		}

		public Mountain(Mountain m) {
			this.start = m.start;
			this.end = m.end;
			this.height = m.height;
		}

	}

	static int calWalkSteps(List<Mountain> mountains) {
		sort(mountains);
		List<Mountain> list = merge(mountains);
		int steps = list.get(list.size() - 1).end - 0;
		for (int i = 0; i < list.size(); ++i) {
			steps += 2 * list.get(i).height;
		}
		return steps;
	}

	/**
	 * Sort by the start position
	 * 
	 * @param mountains
	 */
	static void sort(List<Mountain> mountains) {
		Collections.sort(mountains, new Comparator<Mountain>() {
			@Override
			public int compare(Mountain m1, Mountain m2) {
				if (m1.start < m2.start) {
					return -1;
				} else if (m1.start == m2.start) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}

	/**
	 * Merge the mountain chains, meanwhile update the height.
	 * 
	 * @param mountains
	 * @return A newly merged mountain list
	 */
	static List<Mountain> merge(List<Mountain> mountains) {
		List<Mountain> ret = new ArrayList<>();
		Mountain pre = new Mountain(mountains.get(0));
		for (int i = 1; i < mountains.size(); ++i) {
			Mountain cur = mountains.get(i);
			if (cur.start > pre.end) {
				ret.add(pre);
				pre = cur;
			} else {
				pre.end = Math.max(pre.end, cur.end);
				pre.height = Math.max(pre.height, cur.height);
			}
		}
		ret.add(pre);
		return ret;
	}

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		List<Mountain> mountains = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			String line = s.nextLine().trim();
			String[] strs = line.split(",");
			if (strs.length != 3) {
				s.close();
				throw new Exception("Invalid input!");
			} else {
				int start = Integer.parseInt(strs[0]);
				int end = Integer.parseInt(strs[1]);
				int height = Integer.parseInt(strs[2]);
				if (start > end) {
					s.close();
					throw new Exception("The start position should not bigger than the end position.");
				}
				mountains.add(new Mountain(start, end, height));
			}
		}
		if (mountains.size() > 0) {
			System.out.println(calWalkSteps(mountains));
		} else {
			System.out.println(0);
		}
		s.close();
	}

}
