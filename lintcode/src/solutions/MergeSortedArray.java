package solutions;

import java.util.ArrayList;

public class MergeSortedArray {

	ArrayList<Integer> mergeSortedArray(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> ret = new ArrayList<>();
		int i = 0, j = 0;
		while (i < a.size() && j < b.size()) {
			ret.add(a.get(i) < b.get(j) ? a.get(i++) : b.get(j++));
		}
		if (i < a.size()) {
			ret.addAll(a.subList(i, a.size()));
		}
		if (j < b.size()) {
			ret.addAll(b.subList(j, b.size()));
		}
		return ret;
	}

}
