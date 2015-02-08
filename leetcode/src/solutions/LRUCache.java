package solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	int capacity;
	Node head, tail;
	Map<Integer, Node> map = new HashMap<>();

	LRUCache(int capacity) {
		this.capacity = capacity;
	}

	int get(int key) {
		if (map.containsKey(key)) {
			update(map.get(key));
			return map.get(key).value;
		}
		return -1;
	}

	void set(int key, int value) {
		if (!map.containsKey(key)) {
			add(key, value);
			if (map.size() > capacity) {
				map.remove(tail.key);
				Node prev = tail.prev;
				prev.next = null;
				tail.prev = null;
				tail = prev;
			}
		} else {
			update(map.get(key));
			head.value = value;
		}
	}

	void add(int key, int value) {
		Node node = new Node(key, value);
		map.put(key, node);
		if (head != null) {
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			head = tail = node;
		}
	}

	void update(Node node) {
		if (node != head) {
			if (node != tail) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node.next = head;
				head.prev = node;
			} else {
				tail = tail.prev;
				tail.next = null;
				node.next = head;
				head.prev = node;
			}
			node.prev = null;
			head = node;
		}
	}

	class Node {

		int key;
		int value;
		Node prev;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

}
