package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import struct.UndirectedGraphNode;

public class CloneGraph {

	UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		if (node != null) {
			Queue<UndirectedGraphNode> queue = new LinkedList<>();
			queue.offer(node);
			map.put(node, new UndirectedGraphNode(node.label));
			while (!queue.isEmpty()) {
				UndirectedGraphNode cur = queue.poll();
				for (UndirectedGraphNode nb : cur.neighbors) {
					if (!map.containsKey(nb)) {
						queue.offer(nb);
						map.put(nb, new UndirectedGraphNode(nb.label));
					}
					map.get(cur).neighbors.add(map.get(nb));
				}
			}
		}
		return map.get(node);
	}

}
