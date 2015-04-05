package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Customer {

	String getMostlyBought(String item, String records) {
		String ret = null;
		Map<String, Set<String>> custItems = new HashMap<>();
		Map<String, Set<String>> itemCusts = new HashMap<>();
		parse(records, custItems, itemCusts);
		if (itemCusts.containsKey(item)) {
			Set<String> custs = itemCusts.get(item);
			Map<String, Integer> itemCount = new HashMap<>();
			for (String cust : custs) {
				Set<String> items = custItems.get(cust);
				for (String it : items) {
					if (!it.equals(item)) {
						if (!itemCount.containsKey(it)) {
							itemCount.put(it, 0);
						}
						itemCount.put(it, itemCount.get(it) + 1);
					}
				}
			}
			for (String it : itemCount.keySet()) {
				if (ret == null) {
					ret = it;
				} else {
					if (itemCount.get(ret) < itemCount.get(it)) {
						ret = it;
					}
				}
			}
		}
		return ret;
	}

	void parse(String input, Map<String, Set<String>> custItems, Map<String, Set<String>> itemCusts) {
		if (input != null) {
			String[] strs = input.trim().split("[ \t]+");
			for (int i = 0; i < strs.length - 1; ++i) {
				String cust = strs[i];
				String item = strs[i + 1];
				if (!custItems.containsKey(cust)) {
					custItems.put(cust, new HashSet<String>());
				}
				custItems.get(cust).add(item);
				if (!itemCusts.containsKey(item)) {
					itemCusts.put(item, new HashSet<String>());
				}
				itemCusts.get(item).add(cust);
			}
		}
	}

	public static void main(String[] args) {
		String item1 = "item1";
		String item2 = "item2";
		String records1 = "custA item1 custB item1 custA item2 custB item3 custC item1 custC item3 custD item2";
		String records2 = "custA item1 custB item1 custC item1 custA item2 custB item3 custA item3";
		Customer c = new Customer();
		System.out.println(c.getMostlyBought(item1, records1));
		System.out.println(c.getMostlyBought(item2, records2));
	}

}
