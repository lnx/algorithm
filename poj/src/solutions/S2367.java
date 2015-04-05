package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S2367 {

	static class Node {

		int in;
		int val;
		List<Node> neighbors;

		Node(int val) {
			this.in = 0;
			this.val = val;
			this.neighbors = new ArrayList<Node>();
		}

	}

	static List<Node> sort(List<Node> nodes) {
		List<Node> ret = new ArrayList<Node>();
		while (ret.size() < nodes.size()) {
			List<Node> zeroNodes = new ArrayList<Node>();
			for (Node node : nodes) {
				if (!ret.contains(node) && node.in == 0) {
					zeroNodes.add(node);
				}
			}
			for (Node node : zeroNodes) {
				for (Node neighbor : node.neighbors) {
					--neighbor.in;
				}
			}
			ret.addAll(zeroNodes);
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 1; i <= n; ++i) {
			nodes.add(new Node(i));
		}
		int i = 1;
		while (i <= n) {
			int val = s.nextInt();
			if (val == 0) {
				++i;
			} else {
				nodes.get(i - 1).neighbors.add(nodes.get(val - 1));
				++nodes.get(val - 1).in;
			}
		}
		List<Node> ret = sort(nodes);
		for (Node node : ret) {
			System.out.print(node.val + " ");
		}
		s.close();
	}

}
