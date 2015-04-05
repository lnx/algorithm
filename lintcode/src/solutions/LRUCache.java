package solutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	int capacity;
	Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, .75f, true) {

			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > LRUCache.this.capacity;
			}

		};
	}

	public int get(int key) {
		return map.containsKey(key) ? map.get(key) : -1;
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

}
