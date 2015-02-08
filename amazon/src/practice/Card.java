package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Card {

	public int compare(String line1, String line2) {
		int[] cards1 = getCards(line1);
		int[] cards2 = getCards(line2);
		if (isCheating(cards1, cards2)) {
			return -2;
		}
		int type1 = getType(cards1);
		int type2 = getType(cards2);
		if (type1 != type2) {
			return type1 < type2 ? 1 : -1;
		} else {
			int ret = 0;
			for (int i = 0; i < 4; ++i) {
				if (cards1[i] != cards2[i]) {
					ret = cards1[i] < cards2[i] ? -1 : 1;
					break;
				}
			}
			return ret;
		}
	}

	int[] getCards(String line) {
		int[] cards = new int[4];
		if (line != null) {
			String[] strs = line.split(",");
			if (strs.length == 4) {
				for (int i = 0; i < 4; ++i) {
					cards[i] = toNumber(strs[i]);
				}
			}
			Arrays.sort(cards);
		} else {
			Arrays.fill(cards, '#');
		}
		return cards;
	}

	int toNumber(String str) {
		int ret = 0;
		if (str != null) {
			str = str.toUpperCase();
			if (str.matches("[2-9]||10")) {
				ret = Integer.parseInt(str);
			} else if (str.matches("[JQKA]")) {
				if (str.equals("J")) {
					ret = 11;
				} else if (str.equals("Q")) {
					ret = 12;
				} else if (str.equals("K")) {
					ret = 13;
				} else if (str.equals("A")) {
					ret = 14;
				}
			}
		}
		return ret;
	}

	boolean isCheating(int[] cards1, int[] cards2) {
		Map<Integer, Integer> map = new HashMap<>();
		count(cards1, map);
		count(cards2, map);
		for (int i : map.keySet()) {
			if (map.get(i) > 4) {
				return true;
			}
		}
		return false;
	}

	void count(int[] cards, Map<Integer, Integer> map) {
		for (int i : cards) {
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}
	}

	int getType(int[] cards) {
		if (cards[0] == cards[3]) {
			return 1;
		}
		if (cards[0] + 1 == cards[1] && cards[1] + 1 == cards[2] && (cards[2] + 1 == cards[3] || (cards[2] == 4 && cards[3] == 14))) {
			return 2;
		}
		if ((cards[0] == cards[2]) || (cards[1] == cards[3])) {
			return 3;
		}
		if (cards[0] == cards[1] && cards[2] == cards[3]) {
			return 4;
		}
		if ((cards[0] == cards[1]) || (cards[1] == cards[2]) || (cards[2] == cards[3])) {
			return 5;
		}
		return 6;
	}

}
