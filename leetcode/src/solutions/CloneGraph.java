package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import struct.UndirectedGraphNode;

public class CloneGraph {

	UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (neighbor != null) {
					if (!map.containsKey(neighbor)) {
						queue.offer(neighbor);
						map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					}
					map.get(cur).neighbors.add(map.get(neighbor));
				}
			}
		}
		return map.get(node);
	}

}
